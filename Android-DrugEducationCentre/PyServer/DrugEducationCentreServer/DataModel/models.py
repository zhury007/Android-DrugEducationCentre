# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class Tbl_User(models.Model):
    username = models.CharField(max_length=20)
    account = models.CharField(max_length=20)
    password = models.CharField(max_length=20)