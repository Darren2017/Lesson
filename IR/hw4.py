import requests
from bs4 import BeautifulSoup

def gethtmltext(url):
    try:
        r = requests.get(url)
        r.raise_for_status()
        r.encoding = r.apparent_encoding
        return r.text
    except:
        return ""

def blog_print(html):
    soup = BeautifulSoup(html, "html.parser")
    name = soup.find('span', id='blognamespan')
    print(name)

def main():
    url = 'http://blog.sina.com.cn/u/1361074815'
    html = gethtmltext(url)
    blog_print(html)