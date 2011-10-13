set runtimepath+=$HOME/.vim/
set runtimepath+=$HOME/.vim/after/ftplugins/html
set number
set nocompatible
set nobackup
set nowritebackup
set noswapfile
syntax on
set lines=50
set columns=100
set tabstop=4
set shiftwidth=4
set softtabstop=4
set expandtab

set autoindent

set smartindent
set showmatch
setlocal spell spelllang=en_us
set background=light
colors wombat
filetype indent on
filetype on
filetype plugin on
filetype indent plugin on
let python_highlight_all=1

let g:user_zen_expandabbr_key = '<c-e>'
nmap <silent> <c-n> :NERDTreeToggle<CR>




