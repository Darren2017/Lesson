#! /bin/bash
if [ $# -gt 1 ]
 
then 
 
echo "The lot of parameters is more than the rule" #如果参数超过一个输出错误提示
 
else
 
{
 
touch buff.txt #创建缓冲文件
 
if [ -f"$1" ] #判断是否为普通文件
 
then 
 
echo "The massages is: "
 
echo " This is a simple file." 
 
fi
 
cat $1 | while read line #将目标文件按行读取，最后一行读取后退出
 
while do 
 
for word in $line 
 
do
 
echo -e $word >> buff.txt #将读取的每行word分行（-e）送到缓冲文件buff.txt中
 
done
 
done
 
var=$(cat buff.txt | wc -w) #将统计单词数的结果给var变量
 
echo " The file have $var words."sort -d buff.txt | uniq -c | sort -r #按字典（-d）排序后去重并显示频数rm buff.txt #删除缓冲文件
 
}
 
fi


