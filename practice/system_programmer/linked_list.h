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

#endif
