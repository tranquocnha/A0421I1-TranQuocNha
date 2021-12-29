//
//    function MathChallenge(num) {
//        var numArray = num.toString().split('').reverse();
//        numArray = numArray.map(function(val) {
//            return parseInt(val);
//        })
//        var test = true;
//        var len = numArray.length;
//        newArray = [];
//        while(test) {
//            if (!newArray[0]) {
//                newArray[0] = numArray.shift();
//            }
//            else if (newArray.every(function(val) {
//                return val <= numArray[0];
//            }))
//            {
//                newArray.push(numArray.shift())
//            }
//            else {
//                if (!numArray[0]) {
//                    return '-1';
//                }
//                test = false;
//            }
//        }
//        newArray.sort(function(a, b) {return a - b});
//        var numHolder = numArray.shift();
//        for (var i = 0; i < newArray.length; i++)
//        {
//            if (newArray[i] > numHolder)
//            {
//                numArray.unshift(newArray[i]);
//                newArray[i] = numHolder;
//                break;
//            }
//        }
//        newArray.sort(function(a, b) {return b - a});
//        var resultArray = newArray.concat(numArray);
//        return resultArray.reverse().join('');
//
//    }