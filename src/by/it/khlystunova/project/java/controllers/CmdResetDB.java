package by.it.khlystunova.project.java.controllers;

import by.it.khlystunova.project.java.beans.User;
import by.it.khlystunova.project.java.dao.Dao;
import by.it.khlystunova.project.java.exceptions.WebsiteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CmdResetDB extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)return Actions.LOGIN.command;
        if(user.getRoles_ID()==1){
            Dao dao = Dao.getDao();
            dao.resetDataBase();
        }else throw new WebsiteException("to access this feature, you must have administrator rights");

        return Actions.INDEX.command;
    }
}
