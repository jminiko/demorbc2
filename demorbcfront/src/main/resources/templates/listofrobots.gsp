<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script src="hello.js"></script>
</head>
<body ng-app="demoRBC" ng-controller="robotCtl">
<div ng-repeat="x in data">
<h1>
{{x.name}}
</h1>
<a href="/robot/{{x.robotId}}">{{x.category.name}}</a>
</div>
</body>
    </body>
</html>