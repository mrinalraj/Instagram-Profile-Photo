const cheerio = require("cheerio"),
  cloudscraper = require('cloudscraper'),
  express = require('express'),
  app = express(),
  PORT = process.env.PORT || 5000;


app.get("/:id", (req, res, next) => {
  let id = req.params["id"]
  if (id) {
    cloudscraper.get(`https://instagram.com/${id}/`, (err, response, body) => {
      if (err) {
        res.status(500).write(JSON.stringify({ error: 1, message: err }))
        res.end()
      } else {
        let $ = cheerio.load(body, { xmlMode: true })


        let profile_pic = $("meta[property='og:image']").attr("content")

        if (profile_pic) {
          profile_pic_640x640 = profile_pic.replace("s150x150", "s1080x1080")
          res.send(JSON.stringify({ "error": 0, "message": "Successfully Retrieved Image Link", "profile_pic_url": profile_pic_640x640 }))
        } else {
          res.status(400).write(JSON.stringify({ "error": 1, "message": "Invalid User" }))
          res.end()
        }
      }
    })
  } else {
    res.status(400).write(JSON.stringify({ "error": 1, message: "Invalid ID" }))
    res.end()
  }
})
/**************** The New Code   *******************/
app.get("/p/:id", (req, res, next) => {
  let id = req.params["id"]
  if (id) {
    cloudscraper.get(`https://instagram.com/p/${id}/`, (err, response, body) => {
      if (err) {
        res.status(500).write(JSON.stringify({ error: 1, message: err }))
        res.end()
      } else {
        let $ = cheerio.load(body, { xmlMode: true })


        let profile_pic = $("meta[property='og:image']").attr("content")

        if (profile_pic) {
          res.send(JSON.stringify({ "error": 0, "message": "Successfully Retrieved Image Link", "profile_pic_url": profile_pic }))
        } else {
          res.status(400).write(JSON.stringify({ "error": 1, "message": "Invalid post id" }))
          res.end()
        }
      }
    })
  } else {
    res.status(400).write(JSON.stringify({ "error": 1, message: "Invalid ID" }))
    res.end()
  }
})


app.get("*", (req, res, next) => {
  res.status(404).write(JSON.stringify({ error: 1, message: "Not Found", url: req.url }))
  res.end()
});

app.listen(PORT, err => {
  if (err) {
    throw err
  } else {
    console.log(`Server Started Successfully on ${PORT}`)
  }
})
