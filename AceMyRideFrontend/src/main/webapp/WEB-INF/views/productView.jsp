<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>

<style>
.flex {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-top: 50px; 

}

.single{
border-radius: 5px;
border: none;
  
  box-shadow: 0px 0px 49px 14px rgba(188,190,194,0.39);

  overflow: hidden;
  transform: scale(1);
  transition: transform 300ms ease-out;
 
  flex-shrink: 0;

}

.single:hover{
transform: scale(1.2);
  transition: transform 300ms ease-out;

  
  box-shadow: 0px 0px 70px 20px rgba(188,190,194,0.75);
}

.addThis{
transform: scale(1);
  transition: transform 300ms ease-out;

  }

.single:hover .addThis{
transform: scale(1.2);
  transition: transform 300ms ease-out;
}

.flex > section {
  align-items: center;
  display: flex;
  flex: 1 1 0;
  flex-direction: column;
  text-align: center;
  max-width: 400px;
}

.flex > section > p {
  flex-grow: 1;
}

@media (max-width: 500px) {
  .flex > section {  
    max-width: 250px;
  }
}

.flex ul {
  display: flex;
  justify-content: space-between;
}

.flex aside {
  width: 100%;
}

img {
  width: 400px;
  border-radius: 2px;
}

@media (max-width: 500px) {
  img{
    width: 250px;
  }
}

h2 {
  font-size: 25px;
}

.flex > section {
  background: #fff;
  padding: 1em;
  margin: 0.5em;
  border-radius: 4px;
}

.flex button {
  background-color: #dad2bc;
  
  border: 0;  
  border-radius: 4px;
  cursor: pointer;
  color: #252323;  
  font-weight: bold;
  font-size: 15px;
  padding: 1em 2em;
  
  display: block;
  width: 100%;
}

.flex button:hover {
  background-color: #252323;
  color:#dad2bc;
}

.sort{
background-color: #dad2bc;
  
  border: 0;  
  border-radius: 4px;
  cursor: pointer;
  color: #252323;  
  font-weight: bold;
  font-size: 15px;
  margin-left: 20px;
  padding: 0.5em 1.5em;
  
}

.sortby{
margin-top:15px;
font-size:20px;
}

.sort:hover{
background-color: #252323;
  color:#dad2bc;
}

.flex ul {
  list-style-type: none;
  padding: 0;
}

.flex li {
  background: #eee;
  font-weight: 700;
  padding: 0.3em 0.6em;
  border-radius: 1em;
}

.not-in-stock{
background-color: #eee;
  font-weight: 700;
  padding: 0.3em 0.6em;
  border-radius: 1em;
  color:#BC2D09;
}

.in-stock{
background: #eee;
  font-weight: 700;
  padding: 0.3em 0.6em;
  border-radius: 1em;
  color:#057423;
}

.glyphicon-shopping-cart{
font-size:20px;
}
</style>


<div class="main-content" ng-app="myApp" ng-controller="myCtrl">
<h1>{{categoryName}}</h1>

<div class="container-fluid text-center">
 <div class="row">
  
    <input type="text" ng-model="search">
    <span class="glyphicon glyphicon-search"></span></input>
  
 </div>
 
 <div class="row sortby">
  
   Sort By : <button class="sort" ng-click="orderByMe('name')">Name</button>
             <button class="sort" ng-click="orderByMe('price')">Price</button>
 </div>      
 </div>      


<div class="flex" ng-repeat="item in productList| filter:{name:search}|orderBy:myOrderBy">
    <section class="single">
    <form action="addToCart" method="post">
     <input type="hidden" name="productId" id="productID" value="item.id"/>
     <input type="hidden" name="quantity" id="quantity" value="1"/>
      <img src="download?fileName={{item.imagePath}}" alt="ProductName"/>
      <h2>{{item.name}}</h2>
      <p>{{item.description}}</p>
      <aside>
        <ul>
          <li>Price: {{item.price}} <i class="fa fa-rupee"></i></li>
           
          <li ng-if="item.inStock >= 0" class="in-stock">In Stock</li>
           
           
          <li ng-if="item.inStock === 0 " class="not-in-stock">No Stock</li>
           
        </ul>
        <button type="submit" class="addThis"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</button>
      </aside>
        </form>
    </section>
</div> 

</div>

<script>
var app = angular.module('myApp', []);

 app.controller('myCtrl',function($scope){
 $scope.productList = ${productList};
 $scope.categoryName= ${categoryName};

 $scope.orderByMe=function(x){
$scope.myOrderBy=x;
}
 
 });
</script>

</body>
</html>