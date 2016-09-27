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

                            $scope.bigsInSolution= 0;
                            $scope.smallsInSolution = 0;
                            if ($scope.mySolution.bigs > $scope.mySolution.smalls) {
                                for (var counter = 0; counter < $scope.mySolution.bigs; counter++) {
                                console.log("Inside bigs for loop", counter);
                                    console.log("** about to animate in " + 500 * counter);
//                                    function() { animateBigsBigger(counter); }
/*Ben Helped here*/
                                     var animateLater = animateBigsBigger.bind(null, counter);
                                    $timeout(animateLater, 500 * counter);
                                }
                            } else {
                                for (var counterSmall = 0; counterSmall < $scope.mySolution.smalls; counterSmall++) {
                                                                console.log("Inside small for loop", counterSmall);

                                    console.log("about to animate in " + 500 * counterSmall);
/*And here...*/
                                    var animateLaterSmalls = animateBigsNotBigger.bind(null, counterSmall);
                                    //{ animateBigsNotBigger(counterSmall); }
                                    $timeout(animateLaterSmalls , 500 * counterSmall);
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
            console.log("Moving big from inventory to solution");
            $scope.bigsInSolution++;
            console.log($scope.mySolution.smalls)
            console.log("Counter in animate", counter)
            if (counter < $scope.mySolution.smalls) {
                $scope.inputNumSmalls--;
                console.log("Moving small from inventory to solution");
                $scope.smallsInSolution++;
            }

        }

        var animateBigsNotBigger = function(counterSmall) {
            console.log("animate is running!");
            $scope.inputNumSmalls--;
            console.log("** Moving small from inventory to solution");
            $scope.smallsInSolution++;
            if (counterSmall < $scope.mySolution.bigs) {
                $scope.inputNumBigs--;
                console.log("** Moving big from inventory to solution");
                $scope.bigsInSolution++;
            }

        }


        $scope.factoryName = "The Chocolate Factory";
        $scope.showNoSolution = false;
//        $scope.showInventory = true;
        console.log("ng controller initialized!");

//        $scope.inputNumBigs = 1;
//        $timeout($scope.testTimeout, 1000);



    });