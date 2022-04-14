import requests
while True:
    r = requests.get("https://raw.fastgit.org/521xueweihan/GitHub520/main/hosts")
    open("C:\Windows\System32\drivers\etc\hosts","w").write(r.content.decode())
