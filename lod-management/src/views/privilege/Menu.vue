<template>
  <div class="menu">
    <vxe-toolbar :refresh="{query: reload}" export custom>
      <template v-slot:buttons>
        <vxe-button status="primary"  @click="changeTreeExpansion($refs.xTree)">{{expansionTitle}}</vxe-button>
        <vxe-button status="primary" @click="getInsertEvent">新增菜单</vxe-button>
        <vxe-input v-model="filterName" type="search" placeholder="试试全表搜索"></vxe-input>
      </template>
    </vxe-toolbar>

    <vxe-table
      border
      resizable
      export-config
      keep-source
      highlight-current-row
      highlight-hover-row
      show-overflow
      ref="xTree"
      row-id="id"
      :loading="loading"
      :tree-config="treeConfig"
      :data="tableData">
      <vxe-table-column field="name" title="菜单名称" fixed="left" tree-node>
        <template v-slot="{ row }">
          <span>
            <template v-if="row.children && row.children.length">
              <i class="tree-node-icon" :class="$refs.xTree.isTreeExpandByRow(row) ? 'el-icon-folder-opened' : 'el-icon-folder-add'"></i>
            </template>
            <template v-else>
              <i class="tree-node-icon el-icon-folder"></i>
            </template>
            <span class="menu-name-left">{{ row.name }}</span>
          </span>
        </template>
      </vxe-table-column>
      <vxe-table-column field="id" title="菜单代码" fixed="left"></vxe-table-column>
      <vxe-table-column field="address" title="菜单顺序"></vxe-table-column>
      <vxe-table-column field="date" title="菜单图标" fixed="right"></vxe-table-column>
      <vxe-table-column field="date" title="启用状态" fixed="right">
        <template v-slot="{ row }">
          <span>
            <vxe-button v-if="row.children && row.children.length" type="text" status="success"><i class="vxe-icon--success"></i><span class="menu-name-left">已启用</span></vxe-button>
            <vxe-button v-else type="text" status="warning"><i class="vxe-icon--error"></i><span class="menu-name-left">已禁用</span></vxe-button>
          </span>
        </template>
      </vxe-table-column>
      <vxe-table-column title="操作" width="150" fixed="right">
        <template v-slot="{ row }">
          <vxe-button type="text" status="primary" @click="editEvent(row)"><font-awesome-icon icon="edit"/>&nbsp;编辑</vxe-button>
          <vxe-button type="text" status="danger"><font-awesome-icon icon="trash-alt"/>&nbsp;删除</vxe-button>
        </template>
      </vxe-table-column>
    </vxe-table>

    <vxe-modal ref="xModal" v-model="showEdit" title="编辑&保存" width="800" destroy-on-close>
      <vxe-form :data="formData" :rules="formRules" title-align="right" title-width="100" @submit="submitEvent">
        <vxe-form-item title="Basic information" span="24" title-align="left" title-width="200px" :title-prefix="{icon: 'fa fa-address-card-o'}"></vxe-form-item>
        <vxe-form-item title="Name" field="name" span="12" :item-render="{name: 'input', attrs: {placeholder: '请输入名称'}}"></vxe-form-item>
        <vxe-form-item title="Nickname" field="nickname" span="12" :item-render="{name: 'input', attrs: {placeholder: '请输入昵称'}}"></vxe-form-item>
        <vxe-form-item title="Role" field="role" span="12" :item-render="{name: 'input', attrs: {placeholder: '请输入角色'}}"></vxe-form-item>
        <vxe-form-item title="Sex" field="sex" span="12" :item-render="{name: '$select', options: sexList}"></vxe-form-item>
        <vxe-form-item title="Age" field="age" span="12" :item-render="{name: 'input', attrs: {type: 'number', placeholder: '请输入年龄'}}"></vxe-form-item>
        <vxe-form-item title="Other information" span="24" title-align="left" title-width="200px" :title-prefix="{message: '请填写必填项', icon: 'fa fa-info-circle'}"></vxe-form-item>
        <vxe-form-item title="Number" field="num" span="12" :item-render="{name: 'input', attrs: {type: 'number', placeholder: '请输入数值'}}"></vxe-form-item>
        <vxe-form-item title="Date" field="date3" span="12" :item-render="{name: 'input', attrs: {type: 'date', placeholder: '请选择日期'}}"></vxe-form-item>
        <vxe-form-item title="Address" field="address" span="24" :title-suffix="{message: '啦啦啦，就是这么强大！！！', icon: 'fa fa-question-circle'}" :item-render="{name: 'textarea', attrs: {placeholder: '请输入地址'}}"></vxe-form-item>
        <vxe-form-item align="center" span="24">
          <vxe-button type="submit" status="primary">保存</vxe-button>
          <vxe-button type="reset">重置</vxe-button>
          <vxe-button @click="$refs.xModal.close()">取消</vxe-button>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>
  </div>
</template>

<script>
export default {
  name: 'menu',
  data () {
    return {
      treeExpansion: false,
      expansionTitle: '展开菜单',
      loading: false,
      filterName: '',
      tableData: [{
        id: 1,
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄',
        children: [{
          id: 11,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          id: 12,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }]
      }, {
        id: 2,
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        id: 3,
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄',
        children: [{
          id: 31,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          id: 32,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }]
      }, {
        id: 4,
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }],
      removeList: [],
      treeConfig: {
        children: 'children',
        line: true
      },
      selectRow: null,
      showEdit: false,
      sexList: [
        { label: '', value: '' },
        { label: '女', value: '0' },
        { label: '男', value: '1' }
      ],
      formData: null,
      formRules: {
        name: [
          { required: true, message: '请输入名称' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符' }
        ],
        nickname: [
          { required: true, message: '请输入昵称' }
        ],
        sex: [
          { required: true, message: '请选择性别' }
        ]
      }
    }
  },
  created () {
    this.findList()
  },
  methods: {
    // findList () {
    //   this.loading = true
    //   return new Promise(resolve => {
    //     setTimeout(() => {
    //       this.tableData = XEUtils.clone(window.MOCK_TREE_DATA_LIST, true)
    //       this.loading = false
    //       resolve(this.tableData)
    //     }, 300)
    //   })
    // },
    // insertEvent () {
    //   let xTree = this.$refs.xTree
    //   xTree.createRow({
    //     name: '新数据',
    //     date: XEUtils.toDateString(new Date(), 'yyyy-MM-dd'),
    //     isNew: true
    //   }).then(newRow => {
    //     // 插入到第一行
    //     this.tableData.unshift(newRow)
    //     xTree.syncData().then(() => xTree.setActiveRow(newRow))
    //   })
    // },
    // removeEvent () {
    //   let xTree = this.$refs.xTree
    //   let removeRecords = xTree.getCheckboxRecords()
    //   removeRecords.forEach(row => {
    //     let matchObj = XEUtils.findTree(this.tableData, item => item === row, this.treeConfig)
    //     if (matchObj) {
    //       let { items, index } = matchObj
    //       // 从树节点中移除
    //       let restRow = items.splice(index, 1)[0]
    //       this.removeList.push(restRow)
    //     }
    //   })
    //   xTree.syncData()
    // },
    // reload () {
    //   // 清除所有状态
    //   this.$refs.xTree.clearAll()
    //   return this.findList()
    // },
    // saveEvent () {
    //   this.findList()
    // },
    // getInsertEvent () {
    //   let insertRecords = XEUtils.filterTree(this.tableData, item => item.isNew, this.treeConfig)
    //   this.$XModal.alert(insertRecords.length)
    // },
    // getRemoveEvent () {
    //   let removeRecords = this.removeList
    //   this.$XModal.alert(removeRecords.length)
    // },
    // getUpdateEvent () {
    //   let updateRecords = this.$refs.xTree.getUpdateRecords()
    //   this.$XModal.alert(updateRecords.length)
    // }
    editEvent (row) {
      this.formData = {
        name: row.name,
        nickname: row.nickname,
        role: row.role,
        sex: row.sex,
        age: row.age,
        num: row.num,
        date3: row.date3,
        address: row.address
      }
      this.showEdit = true
    },
    changeTreeExpansion (tree) {
      if (this.treeExpansion) {
        tree.clearTreeExpand()
        this.expansionTitle = '展开菜单'
      } else {
        tree.setAllTreeExpansion(true)
        this.expansionTitle = '关闭菜单'
      }
      this.treeExpansion = !this.treeExpansion
    }
  }
}
</script>

<style lang="scss">
  .menu{
    .menu-name-left{
      padding-left: 5px;
    }
    .vxe-input{
      margin-left: .8em;
    }
  }
</style>
