package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.User;
import entity.searchCount;
import mapper.searchCountMapper;
import mapper.userMapper;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author lxxxxxxy
 * @time 2019/3/4 17:15
 */
public class loginAction extends ActionSupport {

    private ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    public String search() {

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String score="";
        try {
            new searchScore().getScore(username,password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(score=="false"){
            try {
                String error="<script>alert('你输入的学号或密码错误！');window.location.href='./'</script>";
                response.getOutputStream().write(error.getBytes());
//                //解决乱码问题
//                response.setHeader("content-type", "text/html;charset=utf-8");
//                response.getOutputStream().write(error.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("score",score);

        return SUCCESS;

    }

    public String login(){
        searchCountMapper searchCountMapper = this.context.getBean(searchCountMapper.class);
        searchCount searchCount = searchCountMapper.selectCount();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("currentCount",searchCount);
        return SUCCESS;
    }

}
