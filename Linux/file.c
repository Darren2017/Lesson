#include<sys/types.h>
#include<sys/stat.h>
#include<stdlib.h>
#include<string.h>
#include<dirent.h>
#include<errno.h>
#include<pwd.h>
#include<grp.h>
#include<unistd.h>
#include<time.h>
#include<stdio.h>

int dir(char *arg);


//显示文件类型和文件存取权限
void prntmode(struct stat *stbuf){
    switch(stbuf -> st_mode & S_IFMT){
        case S_IFDIR:{
            printf("directory\t");
            break;
        }
        case S_IFCHR:{
            printf("character special file\tspecial device: %d\t", stbuf -> st_rdev);
            break;
        }
        case S_IFBLK:{
            printf("block special file\tspecial device: %d\t", stbuf -> st_rdev);
            break;
        }
        case S_IFREG:{
            printf("regular file\t");
            break;
        }
        case S_IFIFO:{
            printf("named pipe\t");
            break;
        }
    }
    // if(stbuf -> st_mode & S_ISUID){
    //     printf("setuid\t");
    // }
    // if(stbuf -> st_mode & S_ISGID){
    //     printf("setgid\t");
    // }
    // if(stbuf -> st_mode * S_ISVTX){
    //     printf("sticky\t");
    // }
    // printf("permissions: %o\n", stbuf -> st_mode & 0777);
}

//显示文件的属主用户和用户组
void prntuser(struct stat *stbuf){
    struct passwd *pw, *getpwuid();
    struct group *grp, *getgrgid();
    pw = getpwuid(stbuf -> st_uid);
    printf("user ID: %d name: %s\t", stbuf -> st_uid, pw -> pw_name);
    grp = getgrgid(stbuf -> st_gid);
    printf("group ID: %d group: %s\n", stbuf -> st_gid, grp -> gr_name);
}

//显示文件与时间相关属性
void prntimes(struct stat *stbuf){
    char *ctime();
    printf("last access: \t\t%s", ctime(&stbuf -> st_atime));
    printf("last modification: \t%s", ctime(&stbuf -> st_mtime));
    printf("last status change: \t%s", ctime(&stbuf -> st_ctime));
}

int prntfile(char *arg){
    struct stat stbuf;
    if(stat(arg, &stbuf) == -1){
        perror(arg);
        return -1;
    }
    if(arg[strlen(arg) - 1] == '.'){
        return 0;
    }
    printf("file name: %s\t\t", arg);
    // printf("device: %d\t", stbuf.st_dev);
    // printf("i-number: %lld\n", stbuf.st_ino);
    // prntmode(&stbuf);
    printf("links: %d\t", stbuf.st_nlink);
    printf("file size: %lld\n", stbuf.st_size);
    // prntuser(&stbuf);
    prntimes(&stbuf);
    if((stbuf.st_mode & S_IFMT) == S_IFDIR){
        // char now[100];
        // getcwd(now, sizeof(now));
        // strcat(now, "/");
        // strcat(now, arg);

        // printf("%s\n", arg);
        dir(arg);
    }

    return 0;
}

int dir(char *arg){
    DIR *dirp;
    struct dirent *direntp;
    if((dirp = opendir(arg)) == NULL){
        fprintf(stderr, "error message: %s\n", strerror(errno));
        exit(1);
    }
    while((direntp = readdir(dirp)) != NULL){
        // printf("%s\n", direntp -> d_name);
        // char now[100];
        // getcwd(now, sizeof(now));
        // strcat(arg, "/");
        char now[100] = "\0";
        strcat(now, arg);
        strcat(now, "/");
        strcat(now, direntp -> d_name);

        prntfile(now);
        printf("\n\n");
    }
    closedir(dirp);

    exit(0);
}

int main(int avgc, char *argv[])
{
    dir(argv[1]);

    return 0;
}