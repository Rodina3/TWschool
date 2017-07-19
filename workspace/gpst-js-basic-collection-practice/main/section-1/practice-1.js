'use strict';
//寻找集合中相同的元素
module.exports = function collectSameElements(collectionA, collectionB) {
  let same_collection = [];
  for(let i=0; i<collectionA.length;i++)
  {
    for (let j=0;j<collectionB.length;j++)
    {
      if(collectionA[i]==collectionB[j])
      {
        same_collection.push(collectionA[i]);
        break;
      }
    }
  }
  return same_collection;
}

