'use strict';

module.exports = function collectSameElements(collectionA, collectionB) {
  var same_collection = [];
  for(var i=0;i<collectionA.length;i++)
  {
    for(var j=0;j<collectionB[0].length;j++)
    {
      if(collectionA[i] == collectionB[0][j])
      {
        same_collection.push(collectionB[0][j]);
        break;
      }
    }
  }

  return same_collection;
}

