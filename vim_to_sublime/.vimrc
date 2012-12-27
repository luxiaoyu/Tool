    set nocompatible " be iMproved
    filetype off " required!
    set rtp+=~/.vim/bundle/vundle/
    call vundle#rc()
    "插件
    Bundle 'gmarik/vundle'
    Bundle 'AutoComplPop'
    Bundle 'The-NERD-tree'
    Bundle 'Tagbar'
    Bundle 'minibufexpl.vim'
    Bundle 'molokai'
    Bundle 'ZenCoding.vim'
    Bundle 'L9'
    Bundle 'FuzzyFinder'
    Bundle 'WebAPI.vim'
    Bundle 'Gist.vim'
    filetype plugin indent on " required!
    "autocomplpop 设置
    let g:AutoComplPop_IgnoreCaseOption=1
    set ignorecase
    "let g:acp_behaviorKeywordCommand="\<C-x>\<C-o>"
    let g:AutoComplPop_Behavior = { 
                \ 'c': [ {'command' : "\<C-x>\<C-o>",
                \ 'pattern' : ".",
                \ 'repeat' : 0}
                \ ] 
                \}
    filetype plugin on
    set ofu=syntaxcomplete#Complete
    "搜索高亮
    set hlsearch
    "设置NERDTreetagbar的宽度
    let g:NERDTreeWinSize = 20
    let g:tagbar_width=20
    "颜色主题设置
    set t_Co=256
    colorscheme molokai
    "zencoding 设置
    let g:user_zen_expandabbr_key='<S-O>'
    let g:use_zen_complete_tag = 1
    "Gist设置
    let g:gist_detect_filetype = 1
    let g:gist_clip_command = 'xclip -selection clipboard'
    "查找手册
    autocmd FileType php set keywordprg=~/.vim/phpman
    autocmd FileType js,css,html set keywordprg=~/.vim/man
    map <F2> <S-K><CR>
    map! <F2> <Esc><S-K><CR>a
    "检查php语法错误
    map <F5> :! php -l %<CR>
    map! <F5> <Esc>:! php-l %<CR>
    "快速生成tag文件
    map <F3> :! ctags -R<CR>
    map! <F3> <Esc>:! ctags -R<CR>
    "快捷键设置
    map <F11> :NERDTreeToggle<CR>
    map! <F11> <Esc>:NERDTreeToggle<CR>
    map <F12> :TagbarToggle<CR>
    map! <F12> <Esc>:TagbarToggle<CR>
    map <F6> :AcpDisable<CR>
    map! <F6> <Esc>:AcpDisable<CR>a
    "快速查找文件
    map <C-P> :FufCoverageFile<CR>
    map! <C-P> :FufCoverageFile<CR>
    "快速关闭
    map <S-Q> :q<CR>:q<CR>:q<CR>:q<CR>
    "映射复制、粘贴、剪贴ctrl+c ctrl+v ctrl+x
    "map <C-V> "+pa<Esc>
    map! <C-V> <Esc>"+pa
    map <C-C> "+y
    map <C-X> "+x
    " 映射全选 ctrl+a
    map <C-A> ggVG
    map! <C-A> <Esc>ggVG
    "ctrl+s为保存
    map <C-S> :w<CR>
    map! <C-S> <Esc>:w<CR>a
    "ctrl+z撤销
    map <C-Z> :u<CR>
    map! <C-Z> <Esc>:u<CR>a
    "双击时高亮
    map <2-LeftMouse> *
    map! <2-LeftMouse> <c-o>*
    "ctrl+鼠标左键跳转
    map <C-LeftMouse> <C-]>
    map! <C-LeftMouse> <Esc><C-]>
    "光标设在为竖线
    autocmd InsertEnter * silent execute "!gconftool-2 --type string --set /apps/gnome-terminal/profiles/Default/cursor_shape ibeam"
    autocmd InsertLeave * silent execute "!gconftool-2 --type string --set /apps/gnome-terminal/profiles/Default/cursor_shape block"
    autocmd VimLeave * silent execute "!gconftool-2 --type string --set /apps/gnome-terminal/profiles/Default/cursor_shape ibeam"
    "支持鼠标
    set mouse=a
    "显示行数
    set nu
    " 多行缩进
    map <Tab> >
    map <S-Tab> <
    "基本设置
    set encoding=utf-8
    set fileencoding=chinese
    set fileencodings=ucs-bom,utf-8,chinese
    set ambiwidth=double
    set ts=4
    set sw=4
    set wrap "自动换行
    "设置无备份
    set nobackup
    set nowritebackup 
