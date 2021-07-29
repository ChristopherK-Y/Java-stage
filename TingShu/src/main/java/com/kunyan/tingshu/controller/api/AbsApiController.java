package com.kunyan.tingshu.controller.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface AbsApiController {

    default Object doGet(HttpServletRequest req, HttpServletResponse resp) {
        Object result;
        int status;
        try {
            result = new Object() {
                public final boolean success = true;
                public final Object data = doGetInternal(req);
            };
            status = 200;
        } catch (ApiException exc) {
            result = new Object() {
                public final boolean success = false;
                public final String reason = exc.getReason();
            };
            status = exc.getCode();
        } catch (SQLException exc) {
            result = new Object() {
                public final boolean success = false;
                public final String reason = exc.getMessage();
            };
            status = 500;
        } catch (ServletException | IOException exc) {
            result = new Object() {
                public final boolean success = false;
                public final String reason = exc.getMessage();
            };
            exc.printStackTrace();
            status = 500;
        }
        resp.setStatus(status);
        return result;
    }

    default Object doPost(HttpServletRequest req, HttpServletResponse resp) {
        Object result;
        int status;
        try {
            result = new Object() {
                public final boolean success = true;
                public final Object data = doPostInternal(req);
            };
            status = 200;
        } catch (ApiException exc) {
            result = new Object() {
                public final boolean success = false;
                public final String reason = exc.getReason();
            };
            status = exc.getCode();
        } catch (SQLException exc) {
            result = new Object() {
                public final boolean success = false;
                public final String reason = exc.getMessage();
            };
            status = 500;
        } catch (ServletException | IOException exc) {
            result = new Object() {
                public final boolean success = false;
                public final String reason = exc.getMessage();
            };
            status = 500;
            exc.printStackTrace();
        }
        resp.setStatus(status);
        return result;
    }

    Object doGetInternal(HttpServletRequest req) throws ApiException, SQLException, ServletException, IOException;

    Object doPostInternal(HttpServletRequest req) throws ApiException, SQLException, ServletException, IOException;
}
