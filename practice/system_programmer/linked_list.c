#include <stdlib.h>
#include <stdio.h>

#include "linked_list.h"

DListNode dlist_print(DListNode* head)
{
	while(head != NULL)
	{
		printf("%d", (int)(head->data));
		head = head->next;
	}
	printf("\n");
}

int dlist_append(DListNode* head, void* data)
{
	DListNode* last = NULL;
	while(head != NULL)
	{
		last = head;
		head = head->next;
	}

	if (NULL == last)
	{
		return DLIST_RET_INVALID_PARAM;
	}

	DListNode* node = (DListNode*)malloc(sizeof(DListNode));

	if (NULL == node)
	{
		return DLIST_RET_OOM;
	}
	node->data = data;
	node->next = NULL;
	node->prev = last;
	last->next = node;
}

int main()
{
	DListNode* head = (DListNode*)malloc(sizeof(DListNode));
	head->data = (void*)0;
	head->prev = NULL;
	head->next = NULL;

	int i = 0;
	for (i = 1; i <= 10; i ++)
	{
		dlist_append(head, (void*)i);
	}

	dlist_print(head);
}
