export CLICOLOR=1
export LSCOLORS=gxfxcxdxbxegedabagacad

#sets up theprompt color (currently a green similar to linux terminal)
export PS1='\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;36m\]\w\[\033[00m\]\$ '

#enables colorfor iTerm
export TERM=xterm-color

# enable color support of ls and also add handy aliases
if [ -x /usr/bin/dircolors ]; then
    test -r ~/.dircolors && eval "$(dircolors -b ~/.dircolors)" || eval "$(dircolors -b)"
fi

alias grep='grep --color=auto'
alias fgrep='fgrep --color=auto'
alias egrep='egrep --color=auto'

# some more ls aliases
alias ll='ls -lFh'
alias la='ls -Ah'
alias l='ls -CFh'

# Add an "alert" alias for long running commands.  Use like so:
#   sleep 10; alert
alias alert='notify-send --urgency=low -i "$([ $? = 0 ] && echo terminal || echo error)" "$(history|tail -n1|sed -e '\''s/^\s*[0-9]\+\s*//;s/[;&|]\s*alert$//'\'')"'

# git alias
alias g="git"
alias gp="git pull --rebase"
alias gs="git status"
alias gd="git diff"
alias gc="git checkout"
#alias gpt="git push origin news_topic_dev:news_topic_dev"
alias gpt="git push origin develop:develop"
alias gpr="git push origin HEAD:refs/for/news_topic_dev%r=/!:1"
alias ga="git add"
alias gm="git commit -m"
alias gam="git commit -am"
alias grc="git rebase --continue"

export ANDROID_HOME=/Users/luxiaoyu/android/android_ide/sdk/
export PATH=/Users/luxiaoyu/android/android_ide/sdk/platform-tools:/Users/luxiaoyu/android/android_ide/sdk/tools:$PATH
export PATH=/Users/luxiaoyu/android/android_ide/sdk/build-tools/android-4.4W:$PATH
export PATH=/Users/luxiaoyu/android/android_ide/sdk/tools/ant-1.9/bin:/Users/luxiaoyu/android/android_ide/gradle-2.4/bin:$PATH
export JAVA_5_HOME=/System/Library/Java/JavaVirtualMachines/1.5.0.jdk/Contents/Home
export JAVA_6_HOME=/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
export JAVA_7_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0.jdk/Contents/Home
export JAVA_8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home


source /Users/luxiaoyu/android/github/z/z.sh
