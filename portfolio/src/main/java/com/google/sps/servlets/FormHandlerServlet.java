package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("name");
    boolean operation = Boolean.parseBoolean(request.getParameter("operation"));
    double num1 = Double.parseDouble(request.getParameter("num1"));
    double num2 = Double.parseDouble(request.getParameter("num2"));

    String operationString = operation ? "multiplied" : "add";
    double result = operation ? num1 * num2 : num1 + num2;
    String responseText = "Hello " + name + " you " + operationString  + " ";   
    responseText += num1 + " and " +  num2 + " and got " + result;

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + responseText);

    // Write the value to the response so the user can see it.
    response.getWriter().println(responseText);
    // response.sendRedirect("");
  }
}
