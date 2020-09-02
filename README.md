# TiToDoHelper
Android TikTok / Douyin helper app.

# Example
```python
import requests
import json
import base64

authkey = 'xxx'

# XOR

data = {}
data['authkey'] = authkey
data['data'] = "test"

endata = requests.post("http://192.168.2.100:8888/xor/en", data=json.dumps(data)).text
print(endata)

data = {}
data['authkey'] = authkey
data['data'] = endata

dedata = requests.post("http://192.168.2.100:8888/xor/de", data=json.dumps(data)).text
print(dedata)

# Applog

payload = "test"

data = {}
data['authkey'] = authkey
data['data'] = payload

endata = requests.post("http://192.168.2.100:8888/applog/en", data=json.dumps(data)).text
print(endata)

# Device

data = {}
data['authkey'] = authkey
data['phn'] = "+49xxxxxxx"
data['proxy'] = ""

response = requests.post("http://192.168.2.100:8888/device/register", data=json.dumps(data)).text
print(response)
```

# Services
- Applog encryption
- Xlog encryption and decryption
- XOR encryption and decryption
- Device register
- Device otp
- Url sign
- X-Gorgon
- X-Krohnos
- Captcha solving
- API (like, follow, unfollow, search, upload media, create room and many more endpoints)

# Contact
If you are interested you can contact me: **me [at] mrklintscher [dot] de**
