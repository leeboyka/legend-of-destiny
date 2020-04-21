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
                  <el-table :data="gridData" size="small" :show-header="false">
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
                  <div><i class="el-icon-notebook-2 toolbar-icon-size"/>
                    <div class="toolbar-title">目录</div>
                  </div>
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
                      <el-col :span="4">
                        <div style="width: 40px;height: 40px;border-radius: 20px;background-color: #42b983"></div>
                      </el-col>
                      <el-col :span="4">
                        <div style="width: 40px;height: 40px;border-radius: 20px;background-color: #332233"></div>
                      </el-col>
                      <el-col :span="4">
                        <div style="width: 40px;height: 40px;border-radius: 20px;background-color: #7562d0"></div>
                      </el-col>
                      <el-col :span="4">
                        <div style="width: 40px;height: 40px;border-radius: 20px;background-color: #c1c1c1"></div>
                      </el-col>
                      <el-col :span="4">
                        <div style="width: 40px;height: 40px;border-radius: 20px;background-color: #c1c1c1"></div>
                      </el-col>
                      <el-col :span="4">
                        <div style="width: 40px;height: 40px;border-radius: 20px;background-color: #c1c1c1"></div>
                      </el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align: center">正文字体：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="left" :gutter="20" style="padding: 0 20px">
                      <el-col :span="6">
                        <el-button size="mini">楷体</el-button>
                      </el-col>
                      <el-col :span="6">
                        <el-button size="mini">黑体</el-button>
                      </el-col>
                      <el-col :span="6">
                        <el-button size="mini">宋体</el-button>
                      </el-col>
                      <el-col :span="6">
                        <el-button size="mini">雅黑</el-button>
                      </el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align: center">字体大小：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="left" :gutter="20" style="padding: 0 20px">
                      <el-col :span="8">
                        <el-button size="mini">小号字体</el-button>
                      </el-col>
                      <el-col :span="8">
                        <el-button size="mini">正常字体</el-button>
                      </el-col>
                      <el-col :span="8">
                        <el-button size="mini">大号字体</el-button>
                      </el-col>
                    </el-row>
                  </el-col>
                </el-row>
                <el-row style="margin-bottom: 10px">
                  <el-col :span="5" style="text-align: center">页面宽度：</el-col>
                  <el-col :span="19">
                    <el-row type="flex" justify="left" :gutter="20" style="padding: 0 20px">
                      <el-col :span="8">
                        <el-button size="mini">较窄页面</el-button>
                      </el-col>
                      <el-col :span="8">
                        <el-button size="mini">正常页面</el-button>
                      </el-col>
                      <el-col :span="8">
                        <el-button size="mini">较宽页面</el-button>
                      </el-col>
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
                  <div><i class="el-icon-s-tools toolbar-icon-size"/>
                    <div class="toolbar-title">设置</div>
                  </div>
                </div>
              </a>
            </el-popover>
            <div class="toolbar-div">
              <div><i class="el-icon-star-on toolbar-icon-size"/>
                <div class="toolbar-title">收藏</div>
              </div>
            </div>
            <div class="toolbar-div">
              <div><i class="el-icon-s-flag toolbar-icon-size"/>
                <div class="toolbar-title">投票</div>
              </div>
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
                  <div><i class="el-icon-coin toolbar-icon-size"/>
                    <div class="toolbar-title">打赏</div>
                  </div>
                </div>
              </a>
            </el-popover>
          </el-card>
        </el-col>
        <el-col :span="15">
          <el-card shadow="always" :style="note1">
            <el-button size="mini" @click="showChapterContent('0002.text')">获取章节</el-button>
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
import { getChapterContent } from '../../service/api/storyapi'

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
  created () {
    this.showChapterContent('0001.text')
  },
  methods: {
    showChapterContent (chapterName) {
      getChapterContent(chapterName).then(res => {
        if (res.status === 200) {
          this.story = '<p>' + res.data.replace(/\n|\r\n/g, '</p>')
        }
        console.log(res)
      })
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
    height: 4em;
    display: flex;
    justify-content: center;
    align-items: center
  }

  .toolbar-icon-size {
    font-size: 1.5em
  }

  .toolbar-title {
    color: #6f6e6e;
    font-size: 0.8em
  }

  h5 {
    margin-block-start: 1em;
    margin-block-end: 1em;
    color: #6f6e6e;
  }

  .article-tag {
    font-size: 1.5em
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
