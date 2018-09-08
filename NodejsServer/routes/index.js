var express = require("express");
var router = express.Router();
var usr = require("dao/dbConnect");

/* GET home page. */
router.all("/", function (req, res) {
  if (req.cookies.islogin) {
    req.session.islogin = req.cookies.islogin;
  }
  if (req.session.islogin) {
    res.locals.islogin = req.session.islogin;
  }
  res.render("index", {
    title: "HOME",
    test: res.locals.islogin
  });
});

router
  .route("/login")
  .get(function (req, res) {
    if (req.session.islogin) {
      res.locals.islogin = req.session.islogin;
    }
    res.render("login", {
      title: "用户登录",
      test: res.locals.islogin
    });
  });

router.get("/logout", function (req, res) {
  res.clearCookie("islogin");
  req.session.destroy();
  res.redirect("/");
});

router.get("/home", function (req, res) {
  if (req.session.islogin) {
    res.locals.islogin = req.session.islogin;
  }
  if (req.cookies.islogin) {
    req.session.islogin = req.cookies.islogin;
  }
  res.render("home", {
    title: "Home",
    user: res.locals.islogin
  });
});

router
  .route("/reg")
  .get(function (req, res) {
    res.render("reg", {
      title: "注册"
    });
  })


// 主界面API
router
  .route("/login")
  .post(function (req, res) {
    client = usr.connect();
    result = null;
    console.log(req.body);
    let rst = {};
    const getRst = function (uid, Number, status, tipMsg) {
      return {
        uid,
        Number,
        status,
        tipMsg
      }
    }
    usr.doSelectUserSQL(client, req.body.username, function (result) {
      if (result[0] === undefined) {
        Object.assign(rst, getRst("", "", "1", "用户不存在"))
      } else {
        if (result[0].Password === req.body.password) {
          req.session.islogin = req.body.username;
          res.locals.islogin = req.session.islogin;
          res.cookie("islogin", res.locals.islogin, {
            maxAge: 60000
          });
          Object.assign(rst, getRst(res.locals.islogin, result[0].Number, "0", "登陆成功"));
        } else {
          Object.assign(rst, getRst("", "", "1", "密码错误"));
        }
      }
      console.log(rst);
      res.send(rst);
    });
  });


router
  .route("/reg")
  .post(function (req, res) {
    client = usr.connect();
    console.log(req.body);
    let rst = {};
    const getRst = function (uid, Number, status, tipMsg) {
      return {
        uid,
        Number,
        status,
        tipMsg
      }
    }
    usr.doInsertUserSQL(client, req.body.username, req.body.password2, function (
      err
    ) {
      if (err) throw err;
      Object.assign(rst, getRst(req.body.username, "", "0", "注册成功"));
      console.log(rst);
      res.send(rst);
    });
  });



// 修改密码
router
  .route("/changePassword")
  .get(function (req, res) {
    if (req.session.islogin) {
      res.locals.islogin = req.session.islogin;
    }
    if (req.cookies.islogin) {
      req.session.islogin = req.cookies.islogin;
    }
    res.render("changePassword", {
      title: "修改密码",
      test: res.locals.islogin
    });
  })
  .post(function (req, res) {
    client = usr.connect();
    result = null;
    console.log(req.body);
    let rst = {};
    const getRst = function (uid, status, tipMsg) {
      return {
        uid,
        status,
        tipMsg
      }
    }
    //StudentNum,QuestionnaireId,Scores,Status
    usr.doUpdatePersonalSQL(client, req.body.StudentNum, req.body.Password, function (
      err
    ) {
      if (err) throw err;
      Object.assign(rst, getRst("", "0", "修改成功"));
      console.log(rst);
      res.send(rst);
    });
  });

// 查询结果
router
  .route("/result")
  .get(function (req, res) {
    if (req.session.islogin) {
      res.locals.islogin = req.session.islogin;
    }
    if (req.cookies.islogin) {
      req.session.islogin = req.cookies.islogin;
    }
    res.render("result", {
      title: "查询结果",
      test: res.locals.islogin
    });
  })
  .post(function (req, res) {
    client = usr.connect();
    result = null;
    console.log(req.body);
    let rst = {};
    const getRst = function (uid, status, tipMsg) {
      return {
        uid,
        status,
        tipMsg
      }
    }

    const getotherInof = function (scores, alarmstatus, name) {
      return {
        scores,
        alarmstatus,
        name
      }
    }
    //StudentNum
    usr.doSelectResultSQL(client, req.body.StudentNum, function (result) {
      console.log(result);
      if (result[0] === undefined) {
        Object.assign(rst, getRst("", "0", "用户没有参加任何测试"))
      } else {
        Object.assign(rst, getRst("", "0", "用户最近一次测试结果如下"))
        Object.assign(rst, getotherInof(result[0].Scores, result[0].Status, result[0].Name));
      }
      console.log(rst);
      res.send(rst);
    });
  });




module.exports = router;