package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CircleBeans;
import model.Circle;

/**
 * Servlet implementation class CircleServlet
 */
@WebServlet("/CircleServlet")
public class CircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CircleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//リクエストの日本語対応
		request.setCharacterEncoding("UTF-8");
		//レスポンスのhtml指定と日本語対応
		response.setContentType("/text.html;charset=UTF-8");
		
		//リクエストパラメータの取得
		String strRadius = request.getParameter("radius");
		String select = request.getParameter("select");
		
		//入力データをdouble型に変換
		double radius = Double.parseDouble(strRadius);
		
		//モデルを使って計算
		Circle c = new Circle();
		
		//selectで選択した項目によって条件分岐
		double answer = 0;
		String option = "null";
		switch(select) {
		case "面積":
			//面積算出メソッドの呼び出し
			answer = c.area(radius);
			option = "面積";
			break;
		case "円周":
			//円周
			answer = c.circum(radius);
			option = "円周";
			break;
		case "体積":
			//体積
			answer = c.cube(radius);
			option = "体積";
			break;
		}
		
		//beansのオブジェクト生成と初期化
		CircleBeans r = new CircleBeans(answer, option);
		
		//beansをリクエストスコープに入れてjspへフォワード
		request.setAttribute("answer", r);
		RequestDispatcher rd = request.getRequestDispatcher("/circleAnswer.jsp");
		rd.forward(request, response);
	}
	

}
