#!/bin/bash
gcc linked_list.c 
if [ $? -ne 0 ]; then
	exit 1
fi
echo "########### complie done ##########"
./a.out
