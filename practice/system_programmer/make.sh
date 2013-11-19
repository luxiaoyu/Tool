#!/bin/bash
gcc -g dlist.c test_dlist.c
if [ $? -ne 0 ]; then
    echo "########### complie error ##########"
	exit 1
fi
echo "########### complie done ##########"
./a.out
