<template>
  <el-row class="read-view">
    <div class="note" :style="note">
      <el-row type="flex" justify="center" :gutter="10">
        <el-col :span="1" style="min-width: 5em">
        </el-col>
        <el-col :span="15">
          d
        </el-col>
      </el-row>
      <el-row type="flex" justify="center" :gutter="10">
        <el-col :span="1" style="min-width: 5em">
          <el-card shadow="always" :style="note2">
            <el-popover
              placement="right-start"
              width="400"
              trigger="click">
              <div>
                <el-row>目录</el-row>
                <el-divider></el-divider>
                <el-row>
                  <el-table :data="gridData" size="small"  :show-header="false">
                    <el-table-column property="name">
                      <template slot-scope="scope">
                        {{scope.row.date}}{{scope.row.name}}
                      </template>
                    </el-table-column>
                  </el-table>
                </el-row>
              </div>
              <a slot="reference">
                <div class="toolbar-div">
                  <div><i class="el-icon-notebook-2 toolbar-icon-size"/><div class="toolbar-title">目录</div></div>
                </div>
              </a>
            </el-popover>
            <el-popover
              placement="right"
              width="400"
              trigger="click">
              <div>
                <el-row>设置</el-row>
                <el-divider></el-divider>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align:center;height: 40px;line-height: 40px">阅读主题：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="center" :gutter="20" style="padding: 0 20px">
                      <el-col :span="4"><div style="width: 40px;height: 40px;border-radius: 20px;background-color: #42b983"></div></el-col>
                      <el-col :span="4"><div style="width: 40px;height: 40px;border-radius: 20px;background-color: #332233"></div></el-col>
                      <el-col :span="4"><div style="width: 40px;height: 40px;border-radius: 20px;background-color: #7562d0"></div></el-col>
                      <el-col :span="4"><div style="width: 40px;height: 40px;border-radius: 20px;background-color: #c1c1c1"></div></el-col>
                      <el-col :span="4"><div style="width: 40px;height: 40px;border-radius: 20px;background-color: #c1c1c1"></div></el-col>
                      <el-col :span="4"><div style="width: 40px;height: 40px;border-radius: 20px;background-color: #c1c1c1"></div></el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align: center">正文字体：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="left" :gutter="20" style="padding: 0 20px">
                      <el-col :span="6"><el-button size="mini">楷体</el-button></el-col>
                      <el-col :span="6"><el-button size="mini">黑体</el-button></el-col>
                      <el-col :span="6"><el-button size="mini">宋体</el-button></el-col>
                      <el-col :span="6"><el-button size="mini">雅黑</el-button></el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align: center">字体大小：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="left" :gutter="20" style="padding: 0 20px">
                      <el-col :span="8"><el-button size="mini">小号字体</el-button></el-col>
                      <el-col :span="8"><el-button size="mini">正常字体</el-button></el-col>
                      <el-col :span="8"><el-button size="mini">大号字体</el-button></el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align: center">页面宽度：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="left" :gutter="20" style="padding: 0 20px">
                      <el-col :span="8"><el-button size="mini">较窄页面</el-button></el-col>
                      <el-col :span="8"><el-button size="mini">正常页面</el-button></el-col>
                      <el-col :span="8"><el-button size="mini">较宽页面</el-button></el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row type="flex" justify="center" :gutter="20" style="margin-top: 15px">
                  <el-button size="mini" type="primary" round>保存设置</el-button>
                  <el-button size="mini" type="warning" round>恢复默认</el-button>
                </el-row>
              </div>
              <a slot="reference">
                <div class="toolbar-div">
                  <div><i class="el-icon-s-tools toolbar-icon-size"/><div class="toolbar-title">设置</div></div>
                </div>
              </a>
            </el-popover>
            <div class="toolbar-div">
              <div><i class="el-icon-star-on toolbar-icon-size"/><div class="toolbar-title">收藏</div></div>
            </div>
            <div class="toolbar-div">
              <div><i class="el-icon-s-flag toolbar-icon-size"/><div class="toolbar-title">投票</div></div>
            </div>
            <el-popover
              placement="right"
              width="400"
              trigger="click">
              <div>
                <el-row>打赏</el-row>
                <el-divider></el-divider>
                <el-row>
                  <el-col :span="3" :offset="1">宝石：</el-col>
                  <el-col :span="8">
                    <el-rate
                      v-model="value2"
                      :colors="colors"
                      :max="3"
                    >
                    </el-rate>
                  </el-col>
                  <el-col :span="3" :offset="1">金币：</el-col>
                  <el-col :span="8">
                    <el-rate
                      v-model="value2"
                      :colors="colors"
                    >
                    </el-rate>
                  </el-col>
                </el-row>
              </div>
              <a slot="reference">
                <div class="toolbar-div">
                  <div><i class="el-icon-coin toolbar-icon-size"/><div class="toolbar-title">打赏</div></div>
                </div>
              </a>
            </el-popover>
          </el-card>
        </el-col>
        <el-col :span="15">
          <el-card shadow="always" :style="note1">
            <input type="file" @change="loadTextFromFile">
            <div class="article">
              <h2>第一章 风月缘</h2>
              <h5>
                <span class="article-tag-left"><i class="el-icon-s-management article-tag"/>&nbsp;风月缘</span>
                <span class="article-tag-left"><i class="el-icon-user-solid article-tag"/>&nbsp;云逸尘</span>
                <span class="article-tag-left"><i class="el-icon-tickets article-tag"/>&nbsp;3200字</span>
                <span class="article-tag-left"><i class="el-icon-time article-tag"/>&nbsp;2020-01-20 19:00</span>
              </h5>
              <el-divider></el-divider>
              <span type="text" v-html="story"></span>
              <p>晨初，天生丽质的南宫轻舞于惊艳于镜中自己的身体，不觉自慰。</p>
              <p>又在偷看了哥哥南宫玦与继母赵小婵客厅椅上私会，后被哥哥诱骗到花园亭中意乱暧昧，在最后一刻醒悟逃离。</p>
              <p>父南宫易天回后带一盲僧，在仔细检验过裸身的轻舞后，断定其有仙体狐阴。南宫易天便将其送与族长之子北冥惊雷为妻以示讨好，南宫轻舞不愿，离家出逃。</p>
              <p>叶凌云练功时与父叶麟发生激烈矛盾，夜里妹妹叶芷兰偷偷探望，慰以娇躯。叶凌云欲长驱直入时，叶芷兰碍于人伦只得以腿夹、手握使之高潮。</p>
              <p>为证实力，叶凌云只身前往巫族。叶麟派美女高手艾晴柔暗中保护，途中被叶凌云发现。内急时遭叶不准解手并被其以手指塞住阴部，最后在其挑逗下动情，与其肆意交合泄于床上。</p>
              <p>途中叶凌云偷窥在潭中洗澡的北冥冰雪，因能欣赏其美得其倾心，二人遂私定终身。一夜激情过后，北冥冰雪不知所踪。</p>
              <p>叶凌云再次上路，救了遭贼子轻薄的南宫轻舞，两人互生情愫。后来巫族派西门钰寻至，对轻舞温文尔雅无微不至，使轻舞顿生好感。南宫轻舞在二人之间徘徊不定时，二人约定比武，败者自动退出。</p>
              <p>叶凌云胜，南宫轻舞遂答应嫁与他。西门钰告别之时，约南宫轻舞在清风亭做最后一唔，将灌她喝酒直至微醉时，突然从身后抱住她亲吻耳垂，抚弄乳房和私处。</p>
              <p>轻舞挣扎惹怒了西门钰，西门钰使轻舞跪趴在桌子上翘起屁股，一只手扯住瀑布似的秀发防止轻舞逃脱，一只手解开她衣襟并在胸前放了两碗酒，把一对乳头浸在烈酒中玩弄。涨大的铁一般的阳具隔着衣裤摩擦轻舞阴户。</p>
              <p>轻舞对钰本有爱意，乳房在烈酒的刺激下又痒又涨，私处又被亵玩，羞辱和快感交织差点高潮时被叶凌云撞破，叶凌云杀西门钰，愤怒之余对南宫展开强奸。轻舞不愿接连被两人玩弄，守节顽抗，在后庭受辱时恰哥哥南宫玦寻至。</p>
              <p>南宫轻舞喜以为有救，不聊哥哥竟握住她双乳舔她脖子。二人一前一后，在南宫轻舞身上恣意行乐。事后，南宫玦告诉她为了家族必须嫁与北冥惊雷，绝望的南宫轻舞只得听从安排。</p>
              <p>到巫族后，叶凌云为隐瞒身份，化名为云逸尘，拜大祭司东郭幽兰为师学习巫术。</p>
              <p>不料，美女西门燕儿总找他麻烦，约云逸尘比试时，云逸尘遂提出输了就无条件答应胜者一个要求。云逸尘胜出后要燕儿以身相许，燕儿反悔，云逸尘将她扑倒撕去衣服，强行乳交，射了燕儿一脸。</p>
              <p>晚上云逸尘本欲去燕儿房间再寻欢乐，却发现燕儿去东郭幽兰房间诉苦。原来，燕儿和幽兰竟然同性相爱，找他麻烦也是因为嫉妒他成绩突出得到东郭幽兰青睐。幽兰温柔安慰燕儿，到动情处便在幽兰床上宽衣解带，“磨镜”交欢。使云逸尘看得心痒难耐，唤出暗中保护的艾晴柔按到墙上一顿猛操。</p>
              <p>又是每月例行考教之日，东郭幽兰谴燕儿来召云逸尘，途经无人巷时，云逸尘以告知幽兰他猥亵燕儿一事相威胁，得以手探燕儿前阴后庭，终使燕儿高潮。</p>
              <p>在幽兰处，幽兰教二人切磋学习。燕儿忆起几番受辱，徒下杀手却被云逸尘击晕。云逸尘祭出血刀架于燕儿颈上逼幽兰口交，幽兰解开衣襟袒露椒乳，双膝跪地挺起翘臀，为他吸卵吹箫，临近高潮之时幽兰正欲吐出，云逸尘猛的抱住她脑袋，挺进咽喉一泄如注，让幽兰喝下了浓精。</p>
              <p>幽兰欲趁云松懈时反扑，却因乳头突遭咬袭，羞痛之下顿时散功反被血刀火劲入体。云趁机种血蛊逼其保守因血刀导致身份败露一事。幽兰只得屈从，更被令将昏死的燕儿扒个精光，翘臀猫腰趴在身上舔舐揉弄其脖颈乳房。云逸尘则在身后扯着秀发于肛门屁眼里泄了个尽兴。</p>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center" :gutter="10">
        <el-col :span="1" style="min-width: 5em">
        </el-col>
        <el-col :span="15">
          d
        </el-col>
      </el-row>
    </div>
  </el-row>
</template>

<script>
export default {
  name: 'ReadView',
  data () {
    return {
      gridData: [{
        date: '第一章：',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '第二章：',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '第三章：',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '第四章：',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }],
      story: '',
      value2: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
      note: {
        backgroundImage: 'url(' + require('../../assets/background.jpg') + ')',
        backgroundRepeat: 'repeat',
        backgroundSize: '100%',
        padding: '80px 0 50px 0'
      },
      note1: {
        backgroundImage: 'url(' + require('../../assets/paper.jpg') + ')',
        backgroundRepeat: 'repeat',
        backgroundSize: '25px auto'
      },
      note2: {
        backgroundImage: 'url(' + require('../../assets/paper.jpg') + ')',
        backgroundRepeat: 'repeat',
        backgroundSize: '25px auto'
      }
    }
  },

  methods: {
    loadTextFromFile: function (e) {
      const files = e.target.files
      if (files.length > 0) {
        const file = files[0]
        // 读取文件名
        const name = file.name
        // 读取文件大小
        const size = file.size
        console.log(name, size)
        const reader = new FileReader()
        reader.onload = e => this.$emit('load', this.dealNum(e.target.result))
        reader.readAsText(file, 'gb2312')
      }
    },
    dealNum (item) {
      let word = '<p>' + item.replace(/\n|\r\n/g, '</p>')
      this.story = word
      console.log(word)
    }
  }
}
</script>

<style scoped>
  .article {
    text-align: left;
    padding: 0 30px
  }
  .toolbar-div {
    border: 1px solid #EBEEF5;
    height: 4em;display: flex;
    justify-content: center;
    align-items: center
  }
  .toolbar-icon-size {
    font-size:1.5em
  }
  .toolbar-title {
    color: #6f6e6e; font-size: 0.8em
  }
  h5 {
    margin-block-start: 1em;
    margin-block-end: 1em;
    color: #6f6e6e;
  }
  .article-tag {
    font-size:1.5em
  }
  .article-tag-left {
    padding-right: 20px;
  }
  .el-divider--horizontal {
    width: 100%;
    margin: 0.5em 0;
  }
  .el-divider {
    background-color: #c1c1c1;
  }
  .el-col >>> .el-card__body {
     padding: 0;
  }
</style>
