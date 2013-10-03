#!/bin/bash
gcc -g linked_list.c 
if [ $? -ne 0 ]; then
    echo "########### complie error ##########"
	exit 1
fi
echo "########### complie done ##########"
./a.out
