# Java Remote Method Invocation

### 测试环境
1，只有一台电脑</br>
　　客户端和服务端都在本地，如上述hust.rmi.server和hust.rmi.client。在MyEclipse下先执行ServerProgram启动服务（默认设置20s自动关闭），然后执行ClientProgram，通过远程服务获取对象数据。</br>

2，有多台电脑，多个独立IP</br>
　　角色分配：一个服务端+多个客户端。将hust.rmi.model和hust.rmi.service两个package打成jar包，分发到各客户端，客户端执行ClientProgram代码即可。</br>
> 注意：</br>
> a. 客户端和服务端的rmi路径需保持完全一致；</br>
> b. jar包中的内容不需要service的具体实现类，只需要接口即可；</br>
> c. 由于没有考虑线程同步，多客户端情况下可能会出现线程安全问题（后续完善）。</br>

</br></br>
------------

2016-01-26
