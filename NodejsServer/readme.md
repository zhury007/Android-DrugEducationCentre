# 准备工作
## 环境依赖
### node.js
安装最新版本的node
* [官网](https://nodejs.org/en/)

### yarn
在cmd中安装包管理工具
```bash
$ npm install -g yarn
```

### nrm
node库依赖源管理工具
```bash
$ yarn global add nrm

# 切换到taobao源，速度会快很多
$ nrm use taobao
```

## -----其他------非必要------start-----

# 问题： 热部署
npm install -g hotnode
# 说明：
安装后，使用
hotnode ./bin/www 运行程序，实现代码修改后自动更新

## -----其他------非必要------end-------



# 进入目录后
npm install

# 运行
npm start