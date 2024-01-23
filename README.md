## LazyColumn

LazyColumn은 사전에 정의되지 않은 가변적인 개수의 컴포저블을 표시할 수 있는 Scope이다.

`LazyColumn`의 람다 본문에서 `items()` 메서드를 호출하여 항목을 추가할 수 있다. `items()` 메서드의 인수로는 전달할 항목들이 포함된 리스트가 있다.

```kotlin
import androidx.compose.foundation.lazy.items

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) {

        }
    }
}
```

## LazyVerticalGrid

LazyVerticalGrid는 열이 여러 개인 LazyColumn이다. 

각 열의 크기를 지정하는 함수는 두 가지가 있다:

1. **Fixed():** 고정된 크기의 열을 제공한다. 인수로 제공되는 정수는 열의 개수를 의미한다.
2. **Adaptive():** 각 열의 크기에 따라 화면을 배분한다. 인수로 제공되는 정수는 열의 개수를 의미한다.

열과 행 간의 간격을 위해선 다음과 같은 속성을 사용한다:

1. `verticalArragement = Arrangement.spacedBy(/*float*/)`: 행 간격
2. `horizontalArragement = Arrangement.spacedBy(/*float*/)`: 열 간격


