'use strict';

module.exports = function collectSameElements(collectionA, objectB) {
  var same_elements = [];
  for(var i=0;i<collectionA.length;i++)
  {
    for(var j=0;j<objectB.value.length;j++)
    {
      if(collectionA[i].key == objectB.value[j])
      {
        same_elements.push(collectionA[i].key);
        break;
      }
    }
  }
  
  return same_elements;
}
