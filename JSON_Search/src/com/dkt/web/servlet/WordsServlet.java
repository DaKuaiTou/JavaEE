package com.dkt.web.servlet;

import com.alibaba.fastjson.JSON;
import com.dkt.pojo.ResultBean;
import com.dkt.pojo.Words;
import com.dkt.service.WordService;
import com.dkt.service.impl.WordServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.servlet.WordsServlet
 * @Date: 2022年11月05日 09:12
 * @Description:
 */
@WebServlet("/WordsServlet")
public class WordsServlet extends BaseServlet{

    private WordService wordService = new WordServiceImpl();


    // 搜索
    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        ResultBean resultBean = new ResultBean();
        resultBean.setFlag(true);

        try {
            String keyWord = request.getParameter("keyword");
            List<Words> list =  wordService.search(keyWord);
            resultBean.setData(list);

        } catch (Exception throwables) {
            throwables.printStackTrace();
            // 服务器异常
            resultBean.setFlag(false);
            resultBean.setErrorMsg("服务器异常，查询失败");
        }

        // 将resultBean对象转换成JSON响应给客户端
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }
}
