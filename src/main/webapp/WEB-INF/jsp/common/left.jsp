<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/inc_java.jsp"%>
<div class="sidebar-menu nav-collapse">
	<!-- SIDEBAR MENU -->
	<ul>
		<!-- 		<li class="active"><a href="index.html"> <i class="fa fa-tachometer fa-fw"></i> <span class="menu-text">Dashboard</span> <span class="selected"></span> -->
		<!-- 		</a></li> -->
		<c:forEach items="${user_menus}" var="m1">
			<li id="menu1_${m1.id}" class="<c:if test="${fn:length(m1.children) > 0}">has-sub</c:if>"><a href="javascript:;" class=""> <i
					class="fa ${m1.css} fa-fw"></i> <span class="menu-text">${m1.name}</span> <span class="arrow"></span>
			</a>
				<ul class="sub">
					<c:forEach items="${m1.children}" var="m2">
						<li id="menu2_${m2.id}" class=""><a class="" href="<%=path%>${m2.url}"><span class="sub-menu-text">${m2.name}</span></a></li>
					</c:forEach>
				</ul></li>
		</c:forEach>
		<li class=""><a href="index.html"> <i class="fa fa-power-off fa-fw"></i> <span class="menu-text">退出</span> <span class="selected"></span>
		</a></li>
	</ul>
	<input type="hidden" id="left_menuid1" value="${menu1}"> <input type="hidden" id="left_menuid2" value="${menu2}">
	<!-- /SIDEBAR MENU -->
</div>
