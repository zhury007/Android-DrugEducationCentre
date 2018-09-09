# coding=utf-8
from django.shortcuts import render, render_to_response
from django.http import HttpResponse, HttpResponseRedirect
from django.template import RequestContext
from django import forms
from django.template.context_processors import csrf
from DataModel.models import Tbl_User
import json


class UserLoginForm(forms.Form):
    account = forms.CharField(label='account', max_length=20)
    password = forms.CharField(label='password', widget=forms.PasswordInput())


class UserRegistForm(forms.Form):
    username = forms.CharField(label='username', max_length=20)
    account = forms.CharField(label='account', max_length=20)
    password = forms.CharField(label='password', widget=forms.PasswordInput())


def regist(req):
    if req.method == 'POST':
        urf = UserRegistForm(req.POST)
        if urf.is_valid():
            username = urf.cleaned_data['username']
            account = urf.cleaned_data['account']
            password = urf.cleaned_data['password']

            user = Tbl_User.objects.filter(account__exact=account)
            if user:
                Tbl_User.objects.create(
                    username=username,
                    account=account,
                    password=password
                )
                return HttpResponse(json.dumps({"error": 0}))
            else:
                return HttpResponse(json.dumps({"error": 1}))

    else:
        urf = UserRegistForm()

    c = csrf(req)
    c.update({"urf": urf})
    return render_to_response('regist.html', context=c)


def login(req):
    if req.method == 'POST':
        ulf = UserLoginForm(req.POST)
        if ulf.is_valid():
            account = ulf.cleaned_data['account']
            password = ulf.cleaned_data['password']

            user = Tbl_User.objects.filter(
                account__exact=account, password__exact=password)
            if user:
                return HttpResponse(json.dumps({"error": 1}))
            else:
                Tbl_User.objects.create(
                    username=username,
                    account=account,
                    password=password
                )
                return HttpResponse(json.dumps({"error": 0}))
            # if user:
            #     response = HttpResponseRedirect('/index/')

            #     response.set_cookie('account', account, 3600)
            #     return response
            # else:
            #     return HttpResponseRedirect('/login/')
    else:
        ulf = UserLoginForm()
    c = csrf(req)
    c.update({"ulf": ulf})
    return render_to_response('login.html', context=c)


def index(req):
    account = req.COOKIES.get('account', '')
    c = csrf(req)
    c.update({'account': account})
    return render_to_response('index.html', context=c)


def logout(req):
    response = HttpResponse('logout !!')

    response.delete_cookie('account')
    return response
