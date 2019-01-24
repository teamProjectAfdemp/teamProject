<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container pt-4" >
    <div id="routedeck" class="card-deck">
        <div id="loader" class="container pt-4 justify-content-center align-items-center">
            <div class="lds-ellipsis"><div></div><div></div><div></div><div></div></div>
        </div>
        <c:import url="getRoutesJs.jsp"/>
    </div>
</div>


