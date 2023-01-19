# JavaOOPProject
This project is an MVC-structured app that permits users to place and see ads, depending on categories.
It has an authentication system, including login and register features.
Passwords are encrypted and kept safe in a secure database.

There are 2 types of accounts: default user and admin.
A default user can create an account/login into an account, see ads, place ads after selecting a category,
and also delete ONLY the posts he/she created.
The admin has the rights to delete any post.

The project GUIs were manually written by using the Java AWT(Abstract Window Toolkit) API, and they can all be
seen in the view package.

The project uses a MySql database with the following requirements :
    - the database name should be projectoop
    - the database should contain 4 tables : users, cars, electronics, others
    - user = "root", pass = "", but they and the other details like host+ip can
                                be changed in the package model.dao in each class
    - the detailed database structure can be seen in dbstructure.png
