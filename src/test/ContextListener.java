package test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // 回数リストを初期化し、1から10までの値を追加
        List<Integer> countNumbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            countNumbers.add(i);
        }
        ServletContext context = sce.getServletContext();
        context.setAttribute("countNumbers", countNumbers);

        // 入学年度リストを初期化し、2015年から2024年までの値を追加
        List<Integer> enrollmentYears = new ArrayList<>();
        for (int i = 2015; i <= 2024; i++) {
            enrollmentYears.add(i);
        }
        context.setAttribute("enrollmentYears", enrollmentYears);
    }

    // アプリケーションの終了時に呼び出されるメソッド
    public void contextDestroyed(ServletContextEvent sce) {
        // 必要に応じてクリーンアップ処理を行います
    }
}
