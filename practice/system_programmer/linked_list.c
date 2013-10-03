#include <stdlib.h>
#include <stdio.h>

#include "linked_list.h"

static DListNode* dlist_get_node(DListNode* head, size_t index)
{
    DListNode* target = head;
    int i = 0;
    while(i++ < index && target != NULL)
    {
        target = target->next;
    }
    return target;
}

static DListNode* dlist_create_node(void* data)
{
    DListNode* node = (DListNode*)malloc(sizeof(DListNode));
    if (node != NULL)
    {
        node->data = data;
        node->next = NULL;
        node->prev = NULL;
    }
    return node;
}

DListNode dlist_print(DListNode* head)
{
	while((head = head->next) != NULL)
	{
		printf("%d", (int)(head->data));
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

    return DLIST_RET_OK;
}

/**
 * insert node before index
 */
DListRet dlist_insert(DListNode* head, size_t index, void* data)
{
    DListNode* target = dlist_get_node(head, index);
    DListNode* insert_node = dlist_create_node(data);
    if (target == NULL)
    {
        return DLIST_RET_INVALID_PARAM;
    }
    if (insert_node == NULL)
    {
        return DLIST_RET_OOM;
    }

    insert_node->prev = target->prev;
    insert_node->next = target;
    target->prev->next = insert_node;
    target->prev = insert_node;

    return DLIST_RET_OK;
}

DListRet dlist_delete(DListNode* head, size_t index)
{
    DListNode* target = dlist_get_node(head, index);
    if (target == NULL)
    {
        return DLIST_RET_INVALID_PARAM;
    }
    target->prev->next = target->next;
    target->next->prev = target->prev;
    dlist_node_destory(target);

    return DLIST_RET_OK;
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

DListRet dlist_get_by_index(DListNode* head, size_t index, void** data)
{
    DListNode* target = dlist_get_node(head, index);
    if (target == NULL)
    {
        return DLIST_RET_INVALID_PARAM;
    }
    *data = target->data;
    return DLIST_RET_OK;
}

DListRet dlist_set_by_index(DListNode* head, size_t index, void* data)
{
    DListNode* target = dlist_get_node(head, index);
    if (target == NULL)
    {
        return DLIST_RET_INVALID_PARAM;
    }
    target->data = data;
    return DLIST_RET_OK;
}

int main()
{
	DListNode* head = (DListNode*)malloc(sizeof(DListNode));
	head->data = (void*)0;
	head->prev = NULL;
	head->next = NULL;

    // test dlist_append
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

    // test dlist_length
    printf("dlist_length: %d\n", dlist_length(head));

    // test dlist_delete
    if (dlist_delete(head, 5) == DLIST_RET_INVALID_PARAM)
    {
        printf("dlist_delete(head, 5) == DLIST_RET_INVALID_PARAM \n");
    }
	dlist_print(head);

    // test dlist_insert
    dlist_insert(head, 5, (void*)5);
	dlist_print(head);

    // test dlist_get_by_index
    void** data = (void**)malloc(sizeof(void**));
    if(dlist_get_by_index(head, 3, data) == DLIST_RET_OK)
    {
        printf("dlist_get_by_index(3):%d\n", (int)(*data));
    }else
    {
        printf("dlist_get_by_index: DLIST_RET_INVALID_PARAM\n");
    }

    // dlist_set_by_index
    dlist_set_by_index(head, 3, (void*)4);
	dlist_print(head);
    dlist_set_by_index(head, 3, (void*)3);
	dlist_print(head);

    //
}
