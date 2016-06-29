#!/bin/bash
SERVER_NAME=alr-front
TOMCAT_USER=root
SHUTDOWN_WAIT=5
SERVER_TYPE=dev
APP_PATH=build/libs

JAR_NAME=alr-front-0.0.1.jar
ARGUMENTS=-Dspring.profiles.active=${SERVER_TYPE}
JAR=`ls -lt "${APP_PATH}"/*.jar | awk 'NR==1 {print $9}'`



get_pid(){
    echo `ps aux | grep "${APP_PATH}" | grep -v grep | awk '{ print $2 }'`
}
start(){
        pid=$(get_pid)
        if [ -n "$pid" ]
        then
                echo "$SERVER_NAME is already running pid : $pid"
        else
                echo "Starting $SERVER_NAME..."
		  nohup java -Xms128m -Xmx256m -XX:-HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="${APP_PATH}" "${ARGUMENTS}" -jar "${JAR}" > /dev/null & 
               echo "$SERVER_NAME started..."
        fi
        return 0
}

stop(){
        pid=$(get_pid)
        if [ -n "$pid" ]
        then
                echo "$SERVER_NAME($pid) stoping ..."
		   let kwait=$SHUTDOWN_WAIT
                        count=0;
                        until [ `ps -p $pid | grep -c $pid` = '0' ] || [ $count -gt $kwait ]
                                do
                                      
                                        sleep 1
                                        let remainTime=kwait-$count;
                                        let count=$count+1;
                                        echo -n -e "\nwaiting for processes to exit (pid: $pid) $remainTime \n";
                                done

                        if [ $count -gt $kwait ]; then
                                kill -9 $pid
                                echo "$SERVER_NAME($pid) stopped ..."
                        fi
        else
                echo "$SERVER_NAME is not running ..."
        fi
        return 0

}

status(){
        pid=$(get_pid)
        if [ -n "$pid" ]
        then
               echo "$SERVER_NAME pid : $pid"
        else
               echo "$SERVER_NAME is not running"
        fi
        return 0
}



case $1 in
status)
        status
        ;;
start)
        start
	status
        ;;
stop)
        stop
        ;;
restart)
        stop
        start
	status
        ;;
*)
echo $"Usage : $0 {start|stop|restart|status}"
exit 1
esac

