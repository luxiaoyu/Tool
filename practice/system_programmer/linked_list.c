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

DListRet dlist_append(DListNode* head, void* data)
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

DListRet dlist_delete(DListNode* head, size_t index)
{
    // get target node
    DListNode* target = head;
    int i = 0;
    while(i++ < index)
    {
        if (target == NULL)
        {
            return DLIST_RET_INVALID_PARAM;
        }
        target = target->next;
    }

    DListNode* prev = target->prev;
    prev->next = target->next;

    // delete target node
    dlist_node_destory(target);
}

void dlist_node_destory(DListNode* node)
{
    if (node != NULL)
    {
        node->next = NULL;
        node->prev = NULL;
        free(node);
    }
}

size_t dlist_length(DListNode* head)
{
    size_t length = 0;
    while((head = head->next) != NULL) length++;
    return length;
}

int main()
{
	DListNode* head = (DListNode*)malloc(sizeof(DListNode));
	head->data = (void*)0;
	head->prev = NULL;
	head->next = NULL;

	int i = 0;
	for (i = 1; i < 10; i ++)
	{
        /**
         * warning: cast from pointer to integer of different sizeof
         * printf("%d %d\n", sizeof(void*), sizeof(int));
         */
		dlist_append(head, (void*)i);
	}

	dlist_print(head);
    printf("dlist_length: %d\n", dlist_length(head));
    dlist_delete(head, 5);
	dlist_print(head);
}
