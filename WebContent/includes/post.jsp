<%--
  Created by IntelliJ IDEA.
  User: tim-o
  Date: 05.06.2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="post card">
    <div class="card-body container">
        <div class="row">
            <div class="post-avatar col-md-2 col-xl-1"><img src="data:image;base64,${param.user_profilePicture}">
            </div>
            <div class="col-md-10 col-xl-11">
                <div class="post-header"><a href="/profile/${param.user_id}"><b>${param.user_username}</b><span class="handle">@${param.user_handle}</span></a></div>
                <div class="post-content">
                    <p>${param.text}</p>
                    <c:if test="${param.media != ''}">
                        <img src="data:image;base64,${param.media_media}" class="card-img-top">
                    </c:if>
                </div>
                <div class="post-footer">
                    <i class="fas fa-heart" style="color: lightgray;"></i>
                </div>
            </div>
        </div>
    </div>
</div>