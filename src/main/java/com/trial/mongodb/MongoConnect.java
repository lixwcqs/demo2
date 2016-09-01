package com.trial.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by li on 2016/5/1.
 */
public class MongoConnect {
    private final static String SERVER_IP = "192.168.186.153";
    private final static int PORT = 27017;
    private final static String DBNAME = "demo2";
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "1";

    public static void main( String args[] ){
//        connect1();
        connect2();
    }

    private static void connect1(){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "192.168.186.153" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("col");
            System.out.println("Connect to database successfully");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public static MongoClient getMongoClient(){
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress(SERVER_IP,PORT);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//            MongoCredential credential = MongoCredential.createScramSha1Credential(USERNAME, DBNAME, PASSWORD.toCharArray());

        MongoCredential credential = MongoCredential.createCredential(USERNAME,DBNAME,PASSWORD.toCharArray());

        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        return new MongoClient(addrs,credentials);
    }

    public static MongoDatabase getDataBase(String dataBaseName){
        return getMongoClient().getDatabase(dataBaseName);
    }


    public static void connect2(){
        try {
            MongoDatabase demo2 = getDataBase("demo2");
            MongoCollection<Document> col = demo2.getCollection("col");
            Document doc = new Document();
            doc.append("y","100");
            doc.append("z","ff");
            col.insertOne(doc);
            FindIterable  fi = col.find();
            System.out.println(fi);


            MongoCursor it = fi.iterator();
            System.out.println("===================================");
            while (it.hasNext()){
                System.out.println(it.next());
            }





//            System.out.println(demo2.listCollections().first());
            System.out.println();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    private static String ariticle = "读偏好（Read Preference）\n" +
            "\n" +
            "读偏好描述了MongoDB客户端如何将读请求路由到副本集的成员。\n" +
            "\n" +
            "默认情况下，一个应用会将其读操作导向副本集中的primary。从primary中读可以保证读操作返回的是最新的文档。然后，一个应用如果不需 要完全实时的数据，则可以通过分布一些或全部的读操作到副本集的secondary成员上，从而提高读操作的吞吐量或者降低时延。\n" +
            "\n" +
            "MongoDB驱动允许客户端应用对于每个连接、每个collection或者每个操作进行读偏好设置。\n" +
            "\n" +
            "读偏好模式同样对通过mongos连接分片簇的客户端有效。\n" +
            "\n" +
            "注意：如果一个应用的读操作比例很大，则从secondary成员分布式读可以提高吞吐量。\n" +
            "\n" +
            "读偏好模式：\n" +
            "\n" +
            "primary\n" +
            "所有的读操作只访问当前副本集的primary，为默认模式。如果primary不可用，则读操作会产生一个error或抛出一个异常。\n" +
            "\n" +
            "这个模式与标签集模式的读偏好不兼容。\n" +
            "\n" +
            "primaryPreferred\n" +
            "在通常情况下，从副本集的primary上读数据，当primary不可用时，也就是在故障切换的过程中，从副本集的secondary成员上读数据。\n" +
            "\n" +
            "当读偏好包含了标签集时，如果primary可用，客户端从primary上读数据，否则从指定标签的secondary成员上读数据。如果没有匹配标签的secondary时，则产生一个error。\n" +
            "\n" +
            "secondary\n" +
            "读操作只从副本集的secondary成员上读数据。如果没有secondary可用，则产生一个error或者抛出一个异常。\n" +
            "\n" +
            "当读偏好包含标签集时，客户端试图找出指定标签集的secondary成员，并将读操作随机的导向其中一个secondary成员。如果没有相匹配的secondary则产生一个error。\n" +
            "\n" +
            "secondaryPreferred\n" +
            "在通常情况下，读操作从secondary成员上读数据，但是当副本集中只有一个primary成员时，则从primary读数据。\n" +
            "\n" +
            "当读偏好包含标签集时，客户端试图找出指定标签集的secondary成员，并将读操作随机的导向其中一个secondary成员。如果没有相匹配的secondary则产生一个error。\n" +
            "\n" +
            "nearest\n" +
            "驱动从最近的集合成员中读数据时一个成员选择的过程。该模式不关注成员的类型，不管是primary还是secondary成员。\n" +
            "\n" +
            "当读偏好包含标签集时，客户端试图找到指定标签的集合成员并将读操作导向其中任意的一个成员。\n" +
            "\n" +
            "自动重试\n" +
            "\n" +
            "在MongoDB驱动和副本集中mongod实例之间的链接必须平衡两个问题：\n" +
            "\n" +
            "客户端应该试图获取当前的结果，并且任何连接应该尽可能从相同的副本集成员上读取数据。\n" +
            "客户端应该最小化由于连接问题、网络问题或者副本集故障切换造成的不可达时间。\n" +
            "方法如下：\n" +
            "\n" +
            "当连接稳定后尽可能长时间的复用指定mongod的连接。连接与mongod绑定在一起。\n" +
            "如果与mongod的连接失败，则在遵守以后的读偏好模式下，试图连接到一个新的成员。\n" +
            "重连操作对于应用本身是透明的。如果连接允许从secondary成员上读数据，在重连后，应用能够相继从不同的secondary收到两个读取结果。依照个别secondary成员的状态，文档能够反映不同时间的数据库状态。\n" +
            "\n" +
            "只有在试图依照读偏好模式和标签集，连接集合的三个成员后返回error。如果集合少于3个成员，则客户端在连接所有存在的成员后返回error。\n" +
            "在收到error后，驱动使用指定的读偏好模式选择一个新的成员。如果没有指定的读偏好，则使用primary。\n" +
            "\n" +
            "在检测故障切换状态后，驱动会尽快的尝试刷新副本集的状态。\n" +
            "请求联合\n" +
            "\n" +
            "从secondary读数据能够反映数据集在不同时间点的状态，因为副本集的secondary成员相对于primary的最新状态都有不同程度的 滞后。为了防止后面的读操作在时间上的跳跃，驱动能在第一个读操作后把应用线程绑定到指定的集合成员上。线程持续的从相同成员上读取，直到一下情况发生：\n" +
            "\n" +
            "应用执行一个有不同读偏好设置的读操作\n" +
            "线程终止\n" +
            "客户端收到一个socket异常，造成这种情况的原因可能是网络错误，或是在故障切换过程中mongod关闭了连接操作的。这会引起一次重连操作，但其对应用来说是透明的。\n" +
            "如果应用线程在primary不可用时，发出一次primaryPreferred模式的查询操作，则线程会一直固定的访问一个secondary 成员，尽管primary恢复后，也不会切回。同样的，如果线程在所有secondary成员都down掉时，发起一次 secondaryPreferred模式的查询，应用线程会一直从primary上进行读取，尽管secondary恢复。\n" +
            "\n" +
            "成员选择\n" +
            "\n" +
            "客户端通过驱动和分片簇的mongos实例会定期的更新副本集的状态：哪些成员up或down了，哪个成员成为了primary，以及每个mongod实例的延迟。\n" +
            "\n" +
            "对于任意针对非primary成员的操作，驱动会：\n" +
            "\n" +
            "汇集一个合适成员的列表，考虑成员的类型（如secondary、primary或者所有成员）\n" +
            "如果指定标签集，则排除所有不匹配标签集的成员\n" +
            "判断出那个合适的成员离客户端最近\n" +
            "建立一个成员列表，其包含了一个到绝对最近成员的ping距离。\n" +
            "在这些主机中随机选择一个成员，这个成员接收读操作。\n" +
            "分片和mongos\n" +
            "\n" +
            "在多数的分片簇中，一个副本集提供每一个分片，这里读偏好也是可用的。分片簇中的带有读偏好的读操作与不分片副本集是完全相同的。\n" +
            "\n" +
            "与简单的副本集不同的是，在分片簇中，客户端所有与分片的交互都是通过mongos连接到副本集成员上。Mongos负责应用的读偏好，这对应用是透明的。\n" +
            "\n" +
            "在支持所有读偏好的分片环境中没有配置更改的需要。所有的mongos保存着他们自己与副本集成员间的连接池。\n" +
            "\n" +
            "四、副本集内部组成和行为\n" +
            "\n" +
            "Oplog内部组成\n" +
            "\n" +
            "在各种异常情况下，更新一个secondary的oplog可能会比预期时间有所延迟。\n" +
            "\n" +
            "所有副本集的成员会在集合中向其它所有成员发送心跳（ping）包，并且能够将集合中的其它成员的操作加入本地oplog。\n" +
            "\n" +
            "副本集的oplog操作时幂等的。下面的操作时需要幂等的：\n" +
            "\n" +
            "初始同步\n" +
            "快速回滚（post-rollback catch-up）\n" +
            "分片块迁移\n" +
            "读偏好的内部组成\n" +
            "\n" +
            "MongoDB使用单一主复制来确保数据库保持一致性。然而，客户端可能修改每个连接的读偏好来分发读操作到从副本集中的secondary成员上。一个以读为主的部署能够通过分发读取到secondary成员上实现更多的查询。但\n" +
            "\n" +
            "选举内部组成\n" +
            "\n" +
            "选举是副本集选择某个成员成为primary的过程。primary是一个副本集中唯一能够接收写操作的成员。\n" +
            "\n" +
            "下面的事件能够引发一次选举：\n" +
            "\n" +
            "第一次初始化一个副本集\n" +
            "Primary失效。replSetStepDown命令能够使Primary失效，或者当前secondary成员中有合适的选举者且优先级更 高。当Primary与集合中的大多数成员失去联系时也会失效，它会关闭所有的客户端连接，以此防止客户端向一个没有primary成员写数据。\n" +
            "一个secondary成员于primary失去联系。当secondary成员不能与primary建立一个稳定的连接时会发起选举。\n" +
            "故障切换发生。\n" +
            "在选举过程中，所有的成员都有一票，包括隐藏成员、仲裁者和正在恢复的成员。任意mongod能够否决一次选举。在默认的配置中，所有成员都有相同 的机会成为primary。然而可以通过设置优先级来影响选举。在一些结构中，这可能有操作因素来提高一个成员成为primary的可能性。例如，一个在 远程数据中心的成员不应该成为primary。\n" +
            "\n" +
            "任意成员都能否决一次选举，尽管这个成员是一个非投票成员。\n" +
            "\n" +
            "一个成员在下列情况下会否决一次选举：\n" +
            "\n" +
            "如果发起选举的成员不是一个投票集中的成员\n" +
            "如果发起选举的成员没有更新副本集最新的操作\n" +
            "如果发起选举的成员比集合中其他更适合发起选举的成员的优先级低\n" +
            "如果一个只能是secondary成员在选举时是最新的成员，其它合适的集合成员赶上了这个secondary成员的状态，并试图成为primary\n" +
            "如果当前primary比发起选举的成员有更多的最近操作，从投票成员的角度上。\n" +
            "如果当前的primary与发起选举的成员有相同或者更新的操作时，会否决这次选举。\n" +
            "第一个接收到集合中多数选票的成员将成为primary，只到下次选举。了解下面的条件和可能的情况：\n" +
            "\n" +
            "副本集成员每两秒发一次心跳包。如果心跳包没有在10秒内收到响应，则其他成员将这个不良成员标记为不可达的。\n" +
            "副本集成员只与集合内的其它成员进行优先级比较。优先级的绝对值不会影响副本集选举的结果，当然除了0之外，它表明这个成员不能成为primary，也不能发起选举。\n" +
            "如果一个副本集成员在可见的成员中有最高的操作时间，则其不能成为primary\n" +
            "如果一个成员拥有副本集中的最高优先级，但其与最近的oplog操作有10秒的差距，则集合不会选举出primary，只到这个拥有最高优先级的成员更新到最近的操作。\n" +
            "同步\n" +
            "\n" +
            "为了能够跟上副本集的最近状态，设置成员从其它成员同步或者复制oplog记录。成员同步数据在两个不同的点：\n" +
            "\n" +
            "当MongoDB在一个新的或者修复后的成员上创建一个新的数据库时进行初始同步。当一个新的或者修复后的成员加入或重新加入一个集合时，该成员 会等待接收其它成员的心跳包。默认情况下，成员从最近的集合成员进行同步，这个成员有更近的oplog记录，无论其是primary还是其它 secondary。\n" +
            "在初始同步后，复制会继续进行，以此保证副本集的成员能够保持数据更新。\n" +
            "例子：\n" +
            "\n" +
            "如果有两个secondary成员在一个数据中心，一个primary在另一个中，如果同时启动这三个实例（没有数据或oplog存在），则两个 secondary成员都很有可能从primary进行同步，因为任何一个secondary成员都没有更近的oplog记录。如果重启其中的一个 secondary成员，然后当其重新加入到集合后很可能从另一个secondary成员同步数据，因为其距离更近。\n" +
            "如果有一个primary在一个设施中，一个secondary成员在另一个设施中。如果在另一个设施中增加一个secondary成员，那么它将从已存在的secondary成员处同步数据，因为这个成员比primary距离更近。\n" +
            "在MongoDB2.2以后，secondary成员还可以进行以下附加的同步行为：\n" +
            "\n" +
            "如果没有其它成员可用，Secondary成员将从延迟成员上同步数据\n" +
            "Secondary成员不从隐藏成员上读取数据\n" +
            "Secondary成员不会开始从一个正在恢复状态的成员上同步\n" +
            "因为一个成员从另一个成员同步，两个成员必须在buildIndexes域有相同的值，无论是true还是false。\n" +
            "    如果用于来oplog记录的连接有30秒时间没有反应，则Secondary成员停止从这个成员进行同步。如果一个连接超时，则该成员会重新选择一个新的成员进行同步。\n" +
            "\n" +
            "多线程复制\n" +
            "\n" +
            "MongoDB的批量写操作使用的多线程方式。复制过程将一组有大量并发操作的线程中每个批处理分开。\n" +
            "\n" +
            "尽管多线程可能会使操作失序，客户端从secondary成员读取数据不会收到返回的documents，这反映了一个不会在primary存在的中间状态。为了确保一致性，MongoDB会在处理批操作时阻塞所有的读操作。\n" +
            "\n" +
            "为了改进操作应用的性能，MongoDB获取所有保存数据的内存页和批处理将要影响的操作的索引。预取阶段将MongoDB持有写操作锁的时间缩到最短。\n" +
            "\n" +
            "预取索引以提高复制的吞吐量\n" +
            "\n" +
            "默认情况下，secondary在通常会预取与操作影响的document的索引以此提高复制的吞吐量。可以限制只针对于_id域使用预取功能，或者完全关闭该功能。\n" +
            "\n" +
            "五、主从复制\n" +
            "\n" +
            "从1.6版本起，副本集方式就代替了主从复制。所有新的产品架构都使用了副本集而不是主备复制。\n" +
            "\n" +
            "副本集提供了主从关系的功能超集，能够使产品更健壮。主从复制优先复制，使其有大量的非主节点，且只为一个单独的数据库进行复制操作。然而主从复制提供少量冗余，且不能自动故障切换。\n" +
            "\n" +
            "故障切换到从节点（提升）\n" +
            "\n" +
            "永久的就从不可用或毁坏的主节点A切换到从节点B上：\n" +
            "\n" +
            "关闭A\n" +
            "停止B的mongod\n" +
            "备份并移除所有B节点上以local开头的dbpath下的数据文件\n" +
            "以master选项重新启动B的mongod\n" +
            "转换主从关系\n" +
            "\n" +
            "如果有一个主A和一个从B，想要转换它们的关系，则遵循以下过程。这个过程假设A是健康的、最新的和可用的。\n" +
            "\n" +
            "如果A不是健康的，但硬件是正常的，则跳过①和②，并在第⑧步将所有的A文件替换为B文件。\n" +
            "\n" +
            "如果A不是健康的，且硬件也不正常，则使用一个新机器代替A。\n" +
            "\n" +
            "转换主从部署：\n" +
            "\n" +
            "①  使用fsync命令停止A上的写操作\n" +
            "\n" +
            "②  确保B跟上了A的状态\n" +
            "\n" +
            "③  关闭B\n" +
            "\n" +
            "④  备份并移除所有B节点上以local开头的dbpath下的数据文件\n" +
            "\n" +
            "⑤  以master选项重新启动B\n" +
            "\n" +
            "⑥  在B上进行一个写操作，这样可以使oplog提供一个新的同步时间点\n" +
            "\n" +
            "⑦  关闭B，B目前有新的以local开头的数据集文件\n" +
            "\n" +
            "⑧  关闭A，替换A上以local开头的dbpath路径下的所有文件为B上以local开头的dbpath路径下的文件拷贝。确认在拷贝B的本地文件时要进行压缩，因为这些文件有可能很大。\n" +
            "\n" +
            "⑨  以master选项启动B\n" +
            "\n" +
            "⑩  以slave选项启动A，但是包含fastsync\n" +
            "\n" +
            "恢复时过时太多则要重新同步\n" +
            "\n" +
            "从节点异步从主节点上接收写操作，从主节点的oplog上拉取数据。Oplog的长度有限，如果从节点落后太多，重新同步是非常必要的。重新同步从节点，则连接上从节点的mongod，并执行resync命令：\n" +
            "\n" +
            "use admin\n" +
            "\n" +
            "db.runCommand( { resync : 1 } )\n" +
            "\n" +
            "从节点链\n" +
            "\n" +
            "从节点不能被穿成链，它们必须与主节点直接相连。如果一个从节点试图作为另一个从节点的从节点，你将在mongod中看到提示。"
            ;
}
