<%--
  Created by IntelliJ IDEA.
  User: Kino
  Date: 12/29/2020
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<!-- jQuery library -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${url}/js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<!-- SmartMenus jQuery Bootstrap Addon -->

<!-- To Slider JS -->
<script src="${url}/js/sequence.js"></script>
<script src="${url}/js/sequence-theme.modern-slide-in.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="${url}/js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="${url}/js/jquery.simpleLens.js"></script>
<script type="text/javascript" src="${url}/js/jquery.twbsPagination.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="${url}/js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="${url}/js/nouislider.js"></script>
<script type="text/javascript" src="${url}/js/validate.js"></script>
<!-- Custom js -->
<script type="text/javascript" src="${url}/js/custom.js"></script>

<script type="text/javascript" src="${url}/js/jquery.twbsPagination.js"></script>
<script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 10,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>

