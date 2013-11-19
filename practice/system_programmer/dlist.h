#ifndef DLIST_H
#define DLIST_H

typedef struct _DListNode
{
	struct _DListNode* prev;
	struct _DListNode* next;
	void* data;
}DListNode;

typedef enum _DListRet
{
	DLIST_RET_OK,
	DLIST_RET_OOM,
	DLIST_RET_FAIL,
	DLIST_RET_INVALID_PARAM
}DListRet;

DListRet dlist_append(DListNode* head, void* data);
DListRet dlist_delete(DListNode* head, size_t index);
DListRet dlist_insert(DListNode* head, size_t index, void* data);
size_t   dlist_length(DListNode* head);
DListRet dlist_get_by_index(DListNode* head, size_t index, void** data);
DListRet dlist_set_by_index(DListNode* head, size_t index, void* data);
typedef DListRet (*DListVisitFunc)(void* ctx, void* data);
DListRet dlist_foreach(DListNode* head, DListVisitFunc visit, void* ctx);

#endif
