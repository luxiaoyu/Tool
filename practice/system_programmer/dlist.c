#include <stdlib.h>
#include <stdio.h>

#include "dlist.h"

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

DListRet dlist_foreach(DListNode* head, DListVisitFunc visit, void* ctx)
{
	while((head = head->next) != NULL)
	{
        visit(ctx, head->data);
	}
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

