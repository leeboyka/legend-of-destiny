<template>
    <div id="create">
      <el-row  type="flex" justify="center">
        <el-col :span="14">
          <el-upload
            action="https://jsonplaceholder.typicode.com/posts/"
            list-type="picture-card"
            :drag="true"
            :show-file-list="false"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else>
              <br><font-awesome-icon icon="camera"/>
              <br><span style="font-size: 14px;font-style: normal">添加封面图片</span>
            </i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="14">
          <el-input v-model="title" placeholder="请输入标题（最多30字）"></el-input>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="14">
          <quill-editor
            v-model="content"
            ref="myQuillEditor"
            :options="editorOption"
            @focus="onEditorFocus($event)"
            @blur="onEditorBlur($event)"
            @change="onEditorChange($event)">
          </quill-editor>
        </el-col>
      </el-row>
    </div>
</template>

<script>
export default {
  name: 'Create',
  data () {
    return {
      imageUrl: '',
      dialogImageUrl: '',
      dialogVisible: false,

      title: '',

      editor: null,
      content: '<p></p><p><br></p><ol></ol>',
      editorOption: {
        modules: {
          toolbar: [
            [{ 'header': 1 }, { 'header': 2 }],
            ['bold', 'italic', 'underline', 'strike'],
            [{ 'indent': '-1' }, { 'indent': '+1' }],
            [{ 'align': [] }],
            ['blockquote', 'code-block'],
            [{ 'list': 'ordered' }, { 'list': 'bullet' }],
            [{ 'color': [] }, { 'background': [] }],
            ['link', 'image', 'video'],
            ['clean']
          ]
        },
        handlers: {
          'link': function (value) {
            if (value) {
              const href = prompt('Enter the URL')
              this.quill.format('link', href)
            } else {
              this.quill.format('link', false)
            }
          }
        },
        theme: 'snow',
        placeholder: '请输入正文'
      }
    }
  },
  mounted () {
    this.editor = this.$refs.myQuillEditor.quill
  },
  beforeDestroy () {
    this.editor = null
    delete this.editor
  },
  methods: {
    // 准备富文本编辑器
    onEditorReady (editor) {},
    // 富文本编辑器 失去焦点事件
    onEditorBlur (editor) {},
    // 富文本编辑器 获得焦点事件
    onEditorFocus (editor) {},
    // 富文本编辑器 内容改变事件
    onEditorChange (editor) {},

    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    handlePictureCardPreview  (file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    }
  }
}
</script>

<style lang="scss">
  #create {
    text-align: left;

    .el-input__inner {
      border-radius: 0;
      background-image: none;
      border: 1px solid #DCDFE6;
      font-size: xx-large;
      height: 60px;
      line-height: 60px;
      width: 100%;
    }

    .ql-editor {
      height: 400px;
      background-color: #fff;
    }

    .el-upload--picture-card {
      width: 100%;
      height: auto;
      background-color: #fff;
      border: none;
      line-height: unset;
    }

    .el-upload-dragger {
      background-color: #fff;
      border: none;
      width: auto;
      height: auto;
      min-height: 140px;
    }
    .el-upload-list--picture-card .el-upload-list__item {
       width: auto;
       height: auto;
    }
  }
</style>
