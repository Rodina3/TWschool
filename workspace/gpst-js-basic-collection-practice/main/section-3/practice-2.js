'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {

    for(let i=0;i<collectionA.length;i++)
    {
        for(let j=0;j<objectB.value.length;j++)
        {
            if(collectionA[i].key == objectB.value[j])
            {
                collectionA[i].count = process(collectionA[i].count);
                break;
            }
        }
    }
    console.log("3.1----------------")
    console.log(collectionA);
    return collectionA;
}

function process(num)
{
  var loop_count = num;
  for(let i=1;i <= loop_count;i++)
  {
    if(i%3==0)
    {
      num--;
    }
  }
  return num;
}