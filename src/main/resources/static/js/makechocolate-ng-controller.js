angular.module('MakeChocolateAngularApp', [])
   .controller('SampleController', function($scope, $http, $timeout) {

        $scope.makeArray = function(arraySize) {
            var returnArray = [];
            for (var i = 0; i < arraySize; i++) {
                returnArray.push(i);
            }
            return returnArray;
        }


        $scope.getNumSmallsAndBigs = function(numBig, numSmall, goal) {
            console.log("In getNumSmallsAndBigs function in ng controller");

            $http.get("/getSolution.json?numBig=" + numBig + "&numSmall=" + numSmall + "&goal=" + goal)
                .then(
                    function successCallback(response) {
                        console.log(response.data);
                        console.log("Adding data to scope");
                        $scope.mySolution = response.data;
                        if ($scope.mySolution.hasSolution == false) {
                            $scope.showNoSolution = true;
                        } else {
                            $scope.showNoSolution = false;
                            if ($scope.mySolution.bigs > $scope.mySolution.smalls) {
                                for (var counter = 0; counter < $scope.mySolution.bigs; counter++) {
                                    $timeout(animateBigsBigger(counter), 500 * counter);
                                }
                            } else {
                                for (var counter = 0; counter < $scope.mySolution.smalls; counter++) {
                                    $timeout(animateBigsNotBigger(counter), 500 * counter);
                                }
                            }
                        }
                    },
                    function errorCallback(response) {
                        console.log("Unable to get data");
                    })
            };

//        $scope.testTimeout = function() {
//            console.log("testTimeout is running");
//            if ($scope.inputNumBigs > 5) {
//                return;
//            } else {
//                $scope.inputNumBigs += 1;
//                $timeout($scope.testTimeout, 1000);
//            }
//        }

        var animateBigsBigger = function(counter) {
            console.log("animate is running!");
            $scope.inputNumBigs--;
            if (counter < $scope.mySolution.smalls) {
                $scope.inputNumSmalls--;
            }

        }

        var animateBigsNotBigger = function(counter) {
            console.log("animate is running!");
            $scope.inputNumSmalls--;
            if (counter < $scope.mySolution.bigs) {
                $scope.inputNumBigs--;
            }

        }

        $scope.factoryName = "The Chocolate Factory";
        $scope.showNoSolution = false;
//        $scope.showInventory = true;
        console.log("ng controller initialized!");

//        $scope.inputNumBigs = 1;
//        $timeout($scope.testTimeout, 1000);



    });