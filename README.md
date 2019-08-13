# env-MVVM


MVVM架构 采用Retrofit+Rxjava Kotlin语言 androidx

### MVVM

1. Model层：处理数据，获取本地数据或Retrofit网络数据
2. ViewModel层：逻辑处理，这一层不持有Context，防止内存泄露
3. View层：和ViewModel层进行交互，对UI布局一些展示等
